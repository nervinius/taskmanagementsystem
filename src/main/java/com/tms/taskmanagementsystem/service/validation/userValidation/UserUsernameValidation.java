package com.tms.taskmanagementsystem.service.validation.userValidation;

import com.tms.taskmanagementsystem.dto.UserDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class UserUsernameValidation implements UserValidationRule {
    @Override
    public void validate(UserDto userDto) {
        checkNotNull(userDto);
        if (userDto.getUsername() == null) {
            throw new ValidationException("Username must not be empty");
        } else if (userDto.getUsername().length() <= 3 || userDto.getUsername().length() >= 20) {
            throw new ValidationException("Username length must be longer than 3 symbols and shorter than 20 symbols!");
        }

    }
}
