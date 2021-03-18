package com.tms.taskmanagementsystem.service.validation.userValidation;

import com.tms.taskmanagementsystem.dto.UserDto;
import com.tms.taskmanagementsystem.repository.userRepository.UserRepository;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUniquePasswordValidation implements UserValidationRule{

    private UserRepository userRepository;

    @Autowired
    public UserUniquePasswordValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(UserDto userDto) {
        checkNotNull(userDto);
        if (userRepository.existsByPassword(userDto.getPassword())) {
            throw new ValidationException("User with this password already exist!");
        }
    }
}
