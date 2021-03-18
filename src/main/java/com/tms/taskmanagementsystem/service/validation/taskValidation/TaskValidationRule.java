package com.tms.taskmanagementsystem.service.validation.taskValidation;

import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;

public interface TaskValidationRule {
    void validate(TaskDto taskDto);
    default void checkNotNull(TaskDto taskDto) {
        if (taskDto == null) {
            throw new ValidationException("Task must be not null!");
        }
    }
}
