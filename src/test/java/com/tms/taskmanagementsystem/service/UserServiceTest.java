package com.tms.taskmanagementsystem.service;

import com.tms.taskmanagementsystem.domain.User;
import com.tms.taskmanagementsystem.dto.UserDto;
import com.tms.taskmanagementsystem.mapper.SubtaskConverter;
import com.tms.taskmanagementsystem.mapper.TaskConverter;
import com.tms.taskmanagementsystem.mapper.UserConverter;
import com.tms.taskmanagementsystem.repository.subtaskRepository.SubtaskRepository;
import com.tms.taskmanagementsystem.repository.taskRepository.TaskRepository;
import com.tms.taskmanagementsystem.repository.userRepository.UserRepository;
import com.tms.taskmanagementsystem.service.validation.userValidation.UserValidationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserValidationService validationService;

    @Mock
    private UserConverter userConverter;

    @Mock
    private TaskRepository taskRepository;
    @Mock
    private SubtaskRepository subtaskRepository;
    @Mock
    private TaskConverter taskConverter;
    @Mock
    private SubtaskConverter subtaskConverter;


    @Captor
    private ArgumentCaptor<UserDto> userCaptor;

    @InjectMocks
    private UserService victim;

    @BeforeEach
    public void setUp() throws Exception {
        victim = new UserService(validationService, userRepository, userConverter, taskRepository, subtaskRepository, taskConverter, subtaskConverter);
    }

    @Test
    public void shouldCreateUser() {
        UserDto userDto = new UserDto();
        User user = new User();
        when(userConverter.convert(userDto)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);

        Long result = victim.createUser(userDto);

        verify(validationService).validate(userCaptor.capture());
        UserDto captorResult = userCaptor.getValue();

        assertThat(captorResult).isEqualTo(userDto);
        assertThat(user.getId()).isEqualTo(result);
    }

    @Test
    public void shouldFindUserById() {
        when(userRepository.findById(100L)).thenReturn(Optional.ofNullable(user()));
        when(userConverter.convert(user())).thenReturn(userDto());

        UserDto result = victim.findUserById(100L);

        assertThat(result).isEqualTo(userDto());
    }

    private User user() {
        User user = new User();
        user.setUsername("TEST_USERNAME");
        user.setPassword("TEST_PASSWORD");
        user.setId(101L);
        return user;
    }

    private UserDto userDto() {
        UserDto userDto = new UserDto();
        userDto.setUsername("TEST_USERNAME");
        userDto.setPassword("TEST_PASSWORD");
        userDto.setId(101L);
        return userDto;
    }
}
