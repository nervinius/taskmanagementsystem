package com.tms.taskmanagementsystem.service.validation.subtaskValidation;

import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class SubtaskStatusValidation implements SubtaskValidationRule {
    @Override
    public void validate(SubtaskDto subtaskDto) {
        checkNotNull(subtaskDto);
        if (subtaskDto.getTaskStatus() == null) {
            throw new ValidationException("Subtask Status must be not null");
        }
    }
}
