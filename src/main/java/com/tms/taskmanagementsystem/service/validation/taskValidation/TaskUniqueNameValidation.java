package com.tms.taskmanagementsystem.service.validation.taskValidation;

import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.repository.taskRepository.TaskRepository;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class TaskUniqueNameValidation implements TaskValidationRule {

    private TaskRepository taskRepository;

    public TaskUniqueNameValidation(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void validate(TaskDto taskDto) {
        checkNotNull(taskDto);
        if (taskRepository.existsByTaskName(taskDto.getTaskName())) {
            throw new ValidationException("Task with this name already exist!");
        }
    }
}
