package com.tms.taskmanagementsystem.service.validation.userValidation;


import com.tms.taskmanagementsystem.dto.UserDto;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordValidation implements UserValidationRule {
    @Override
    public void validate(UserDto userDto) {
        checkNotNull(userDto);
        if (userDto.getPassword() == null) {
            throw new ValidationException("Password must not be empty");
        } else if (userDto.getPassword().length() <= 3 || userDto.getPassword().length() >= 20) {
            throw new ValidationException("Password length must be longer than 3 symbols and shorter than 20 symbols!");
        }
    }
}
