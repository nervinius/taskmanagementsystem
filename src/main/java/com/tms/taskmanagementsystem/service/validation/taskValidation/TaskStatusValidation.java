package com.tms.taskmanagementsystem.service.validation.taskValidation;

import com.tms.taskmanagementsystem.domain.Subtask;
import com.tms.taskmanagementsystem.domain.TaskStatus;
import com.tms.taskmanagementsystem.dto.TaskDto;
import com.tms.taskmanagementsystem.mapper.TaskConverter;
import com.tms.taskmanagementsystem.repository.subtaskRepository.SubtaskRepository;
import com.tms.taskmanagementsystem.service.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskStatusValidation implements TaskValidationRule {
    private SubtaskRepository subtaskRepository;
    private TaskConverter taskConverter;

    @Autowired
    public TaskStatusValidation(SubtaskRepository subtaskRepository, TaskConverter taskConverter) {
        this.subtaskRepository = subtaskRepository;
        this.taskConverter = taskConverter;
    }

    @Override
    public void validate(TaskDto taskDto) {

        checkNotNull(taskDto);
        if (taskDto.getTaskStatus() == null) {
            throw new ValidationException("Task Status must be not null!");
        }
        if (taskDto.getTaskStatus().equals(TaskStatus.Done)) {
            List<Subtask> subtasks = subtaskRepository.findAllByTask(taskConverter.convert(taskDto));
            for (Subtask subtask: subtasks) {
                if (subtask.getTaskStatus().equals(TaskStatus.Backlog) || subtask.getTaskStatus().equals(TaskStatus.DevInProgress)){
                    throw new ValidationException("To close task all subtasks should have status - Done");
                }
            }
        }
    }
}
