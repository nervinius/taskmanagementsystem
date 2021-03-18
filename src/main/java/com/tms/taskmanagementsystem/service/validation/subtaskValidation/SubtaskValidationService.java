package com.tms.taskmanagementsystem.service.validation.subtaskValidation;

import com.tms.taskmanagementsystem.dto.SubtaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class SubtaskValidationService {

    private final Set<SubtaskValidationRule> validationRules;

    @Autowired
    public SubtaskValidationService(Set<SubtaskValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(SubtaskDto subtaskDto) {
        validationRules.forEach(s -> s.validate(subtaskDto));
    }
}
