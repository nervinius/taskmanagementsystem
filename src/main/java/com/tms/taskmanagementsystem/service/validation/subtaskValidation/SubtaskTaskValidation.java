package com.tms.taskmanagementsystem.service.validation.subtaskValidation;

import com.tms.taskmanagementsystem.domain.TaskStatus;
import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.service.TaskService;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubtaskTaskValidation implements SubtaskValidationRule{
    private TaskService taskService;

    @Autowired
    public SubtaskTaskValidation(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void validate(SubtaskDto subtaskDto) {
        checkNotNull(subtaskDto);
        TaskDto taskDto = taskService.findTaskById(subtaskDto.getTask());
        if (taskDto.getTaskStatus().equals(TaskStatus.Done)) {
            throw new ValidationException("Task status is done , Subtask cannot be created");
        }
    }
}
