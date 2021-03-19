package com.tms.taskmanagementsystem.service.validation.userValidation;

import com.tms.taskmanagementsystem.dto.UserDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;

public interface UserValidationRule {

    void validate(UserDto userDto);

    default void checkNotNull(UserDto userDto) {
        if (userDto == null) {
            throw new ValidationException("User must be not null!");
        }
    }
}
