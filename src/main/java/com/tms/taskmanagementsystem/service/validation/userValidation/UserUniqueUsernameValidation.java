package com.tms.taskmanagementsystem.service.validation.userValidation;

import com.tms.taskmanagementsystem.dto.UserDto;
import com.tms.taskmanagementsystem.repository.userRepository.UserRepository;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUniqueUsernameValidation implements UserValidationRule {

    private UserRepository userRepository;

    @Autowired
    public UserUniqueUsernameValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserDto userDto) {
        checkNotNull(userDto);
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new ValidationException("User with this Username already exist");
        }
    }
}
