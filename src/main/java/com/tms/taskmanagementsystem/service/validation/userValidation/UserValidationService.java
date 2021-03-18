package com.tms.taskmanagementsystem.service.validation.userValidation;

import com.tms.taskmanagementsystem.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserValidationService {

    private final Set<UserValidationRule> validationRules;

    @Autowired
    public UserValidationService(Set<UserValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(UserDto userDto) {
        validationRules.forEach(s -> s.validate(userDto));
    }
}
