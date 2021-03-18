package com.tms.taskmanagementsystem.controller;

import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.service.SubtaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subtask")
public class SubtaskController {

    @Autowired
    private SubtaskService subtaskService;

    @PostMapping("/createSubtask")
    public ResponseEntity<Long> createSubtask(@RequestBody SubtaskDto subtaskDto) {
        Long id = subtaskService.createSubtask(subtaskDto);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public List<SubtaskDto> getAllSubtasks(@PathVariable("id") Long id) {
        return subtaskService.showAllSubtask();
    }

    @DeleteMapping("/deleteSubtask/{id}")
    public void deleteTaskById(@PathVariable("id") Long id) {
        subtaskService.deleteSubtaskById(id);
    }

    @PutMapping("/updateSubtask/{id}")
    public void updateTask(@PathVariable("id") Long id, @RequestBody SubtaskDto subtaskDto) {
        subtaskDto.setId(id);
        subtaskService.updateSubtask(subtaskDto);
    }

    @GetMapping("{id}")
    public SubtaskDto getSubtaskById(@PathVariable("id") Long id) {
        return subtaskService.findSubtaskById(id);
    }
}
