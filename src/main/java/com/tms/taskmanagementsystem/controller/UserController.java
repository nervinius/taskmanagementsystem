package com.tms.taskmanagementsystem.controller;

import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.dto.UserDto;
import com.tms.taskmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<Long> createUser(@RequestBody UserDto userDto) {
        Long id = userService.createUser(userDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/userTasks/{id}")
    public List<TaskDto> getAllUserTasks(@PathVariable("id") Long id) {
        return userService.getAllUserTasks(id);
    }

    @GetMapping("/userSubtasks/{id}")
    public List<SubtaskDto> getAllUserSubtasks(@PathVariable("id") Long id) {
        return userService.getAllUserSubtasks(id);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        userService.userUpdate(userDto);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }
}
