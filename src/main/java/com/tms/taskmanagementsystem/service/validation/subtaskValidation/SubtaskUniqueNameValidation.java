package com.tms.taskmanagementsystem.service.validation.subtaskValidation;

import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.repository.subtaskRepository.SubtaskRepository;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class SubtaskUniqueNameValidation implements SubtaskValidationRule {

    private SubtaskRepository subtaskRepository;

    public SubtaskUniqueNameValidation(SubtaskRepository subtaskRepository) {
        this.subtaskRepository = subtaskRepository;
    }

    @Override
    public void validate(SubtaskDto subtaskDto) {
        checkNotNull(subtaskDto);
        if (subtaskRepository.existsBySubtaskName(subtaskDto.getSubtaskName())) {
            throw new ValidationException("Subtask with this name already exist");
        }
    }
}
