package com.tms.taskmanagementsystem.service.validation.taskValidation;

import com.tms.taskmanagementsystem.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class TaskValidationService {

    private final Set<TaskValidationRule> validationRules;

    @Autowired
    public TaskValidationService(Set<TaskValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(TaskDto taskDto) {
        validationRules.forEach(s -> s.validate(taskDto));
    }
}
