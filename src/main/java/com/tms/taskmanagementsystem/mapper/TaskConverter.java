package com.tms.taskmanagementsystem.mapper;

import com.tms.taskmanagementsystem.domain.Task;
import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.repository.userRepository.UserRepository;
import com.tms.taskmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class TaskConverter {

    private UserRepository userRepository;

    @Autowired
    public TaskConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Task convert(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTaskName(taskDto.getTaskName());
        task.setAssignee(userRepository.findById(taskDto.getAssignee()).orElseThrow(() -> new NoSuchElementException("No user found by id : " + taskDto.getAssignee())));
        task.setTaskGroup(taskDto.getTaskGroup());
        task.setTaskStatus(taskDto.getTaskStatus());
        task.setTimeSpentInMinutes(taskDto.getTimeSpentInMinutes());
        return task;
    }

    public TaskDto convert(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTaskName(task.getTaskName());
        taskDto.setAssignee(task.getAssignee().getId());
        taskDto.setTaskGroup(task.getTaskGroup());
        taskDto.setTaskStatus(task.getTaskStatus());
        taskDto.setTimeSpentInMinutes(task.getTimeSpentInMinutes());
        return taskDto;
    }
}
