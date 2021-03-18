package com.tms.taskmanagementsystem.service.validation.taskValidation;

import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class TaskGroupValidation implements TaskValidationRule {
    @Override
    public void validate(TaskDto taskDto) {
        checkNotNull(taskDto);
        if (taskDto.getTaskGroup() == null) {
            throw new ValidationException("Task group must be not null");
        }
    }
}
