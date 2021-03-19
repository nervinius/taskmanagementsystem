package com.tms.taskmanagementsystem.service.validation.subtaskValidation;

import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class SubtaskNameValidation implements SubtaskValidationRule {
    @Override
    public void validate(SubtaskDto subtaskDto) {
        checkNotNull(subtaskDto);
        if (subtaskDto.getSubtaskName() == null) {
            throw new ValidationException("Subtask name must not be empty");
        } else if (subtaskDto.getSubtaskName().length() <= 3 || subtaskDto.getSubtaskName().length() >= 20) {
            throw new ValidationException("Subtask name length must be longer than 3 symbols and shorter than 20 symbols!");
        }
    }
}
