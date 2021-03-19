package com.tms.taskmanagementsystem.service.validation.taskValidation;

import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class TaskNameValidation implements TaskValidationRule {
    @Override
    public void validate(TaskDto taskDto) {
        checkNotNull(taskDto);
        if (taskDto.getTaskName() == null) {
            throw new ValidationException("Task name must not be empty");
        } else if (taskDto.getTaskName().length() <= 3 || taskDto.getTaskName().length() >= 20) {
            throw new ValidationException("Task name length must be longer than 3 symbols and shorter than 20 symbols!");
        }
    }
}
