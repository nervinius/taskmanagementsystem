package com.tms.taskmanagementsystem.service.validation.subtaskValidation;

import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;

public interface SubtaskValidationRule {

    void validate(SubtaskDto subtaskDto);
    default  void checkNotNull(SubtaskDto subtaskDto) {
        if (subtaskDto == null) {
            throw new ValidationException("Subtask must be not null!");
        }
    }
}
