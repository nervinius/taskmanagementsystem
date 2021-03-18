package com.tms.taskmanagementsystem.controller;

import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/createTask")
    public ResponseEntity<Long> createTask(@RequestBody TaskDto taskDto) {
        Long id = taskService.createTask(taskDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.showAllTasks();
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTaskById(@PathVariable("id") Long id) {
        taskService.deleteTaskById(id);
    }

    @PutMapping("/updateTask/{id}")
    public void updateTask(@PathVariable("id") Long id, @RequestBody TaskDto taskDto) {
        taskDto.setId(id);
        taskService.taskUpdate(taskDto);
    }

    @GetMapping("{id}")
    public TaskDto getTaskById(@PathVariable("id") Long id) {
        return taskService.findTaskById(id);
    }

}
