package com.tms.taskmanagementsystem.service;

import com.tms.taskmanagementsystem.domain.Task;
import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.mapper.TaskConverter;
import com.tms.taskmanagementsystem.repository.taskRepository.TaskRepository;
import com.tms.taskmanagementsystem.service.validation.taskValidation.TaskValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskValidationService validationService;
    private TaskConverter taskConverter;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskValidationService validationService, TaskConverter taskConverter) {
        this.taskRepository = taskRepository;
        this.validationService = validationService;
        this.taskConverter = taskConverter;
    }

    @Transactional
    public Long createTask(TaskDto taskDto) {
        validationService.validate(taskDto);
        Task task = taskConverter.convert(taskDto);
        taskRepository.save(task);
        return task.getId();
    }

    @Transactional
    public void deleteTaskById(Long id) {
        taskRepository.findById(id)
                .ifPresent(taskRepository::delete);
    }

    public List<TaskDto> showAllTasks() {
        return taskRepository.findAll().stream()
                .map(task -> taskConverter.convert(task))
                .collect(Collectors.toList());
    }

    public void taskUpdate(TaskDto taskDto) {
        validationService.validate(taskDto);
        Task task = taskConverter.convert(taskDto);
        taskRepository.save(task);
    }

    public TaskDto findTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("Task not found by id : " + id));
    }
}
