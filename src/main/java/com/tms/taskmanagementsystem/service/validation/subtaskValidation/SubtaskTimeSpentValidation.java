package com.tms.taskmanagementsystem.service.validation.subtaskValidation;

import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class SubtaskTimeSpentValidation implements SubtaskValidationRule {
    @Override
    public void validate(SubtaskDto subtaskDto) {
        checkNotNull(subtaskDto);
        if (subtaskDto.getTimeSpentInMinutes() < 0) {
            throw new ValidationException("Time Spent shouldn't be less then 0");
        }
    }
}
