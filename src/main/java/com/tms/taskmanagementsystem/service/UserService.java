package com.tms.taskmanagementsystem.service;

import com.tms.taskmanagementsystem.domain.User;
import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.dto.UserDto;
import com.tms.taskmanagementsystem.mapper.SubtaskConverter;
import com.tms.taskmanagementsystem.mapper.TaskConverter;
import com.tms.taskmanagementsystem.mapper.UserConverter;
import com.tms.taskmanagementsystem.repository.subtaskRepository.SubtaskRepository;
import com.tms.taskmanagementsystem.repository.taskRepository.TaskRepository;
import com.tms.taskmanagementsystem.repository.userRepository.UserRepository;
import com.tms.taskmanagementsystem.service.validation.userValidation.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserValidationService validationService;
    private UserRepository userRepository;
    private UserConverter converter;
    private TaskRepository taskRepository;
    private SubtaskRepository subtaskRepository;
    private TaskConverter taskConverter;
    private SubtaskConverter subtaskConverter;

    @Autowired
    public UserService(UserValidationService validationService, UserRepository userRepository, UserConverter converter, TaskRepository taskRepository, SubtaskRepository subtaskRepository, TaskConverter taskConverter, SubtaskConverter subtaskConverter) {
        this.validationService = validationService;
        this.userRepository = userRepository;
        this.converter = converter;
        this.taskRepository = taskRepository;
        this.subtaskRepository = subtaskRepository;
        this.taskConverter = taskConverter;
        this.subtaskConverter = subtaskConverter;
    }

    @Transactional
    public Long createUser(UserDto userDto) {
        validationService.validate(userDto);
        User user = converter.convert(userDto);
        userRepository.save(user);
        return user.getId();
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> converter.convert(user))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.findById(id)
                .ifPresent(userRepository::delete);
    }

    public void userUpdate(UserDto userDto) {
        validationService.validate(userDto);
        User user = converter.convert(userDto);
        userRepository.save(user);
    }

    public List<TaskDto> getAllUserTasks(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User By id not found - " + id));
        return taskRepository.findAllByAssignee(user).stream()
                .map(task -> taskConverter.convert(task))
                .collect(Collectors.toList());
    }

    public List<SubtaskDto> getAllUserSubtasks(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User By id not found - " + id));
        return subtaskRepository.findAllByAssignee(user).stream()
                .map(subtask -> subtaskConverter.convert(subtask))
                .collect(Collectors.toList());
    }

    public UserDto findUserById(Long id) {
        return userRepository.findById(id)
                .map(converter::convert)
                .orElseThrow(() -> new NoSuchElementException("No user found by id : " + id));
    }

    public User findUserByIdWithoutConverter(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No user found by id : " + id));
    }
}
