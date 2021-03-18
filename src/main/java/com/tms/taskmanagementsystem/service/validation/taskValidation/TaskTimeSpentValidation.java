package com.tms.taskmanagementsystem.service.validation.taskValidation;

import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class TaskTimeSpentValidation implements TaskValidationRule {
    @Override
    public void validate(TaskDto taskDto) {
        checkNotNull(taskDto);
        if (taskDto.getTimeSpentInMinutes() < 0) {
            throw new ValidationException("Time Spent shouldn't be less then 0");
        }
    }
}
