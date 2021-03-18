package com.tms.taskmanagementsystem.mapper;

import com.tms.taskmanagementsystem.domain.Subtask;
import com.tms.taskmanagementsystem.dto.SubtaskDto;
import com.tms.taskmanagementsystem.repository.taskRepository.TaskRepository;
import com.tms.taskmanagementsystem.repository.userRepository.UserRepository;
import com.tms.taskmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class SubtaskConverter {

    private UserRepository userRepository;
    private TaskRepository taskRepository;

    @Autowired
    public SubtaskConverter(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public Subtask convert(SubtaskDto subtaskDto) {
        Subtask subtask = new Subtask();
        subtask.setId(subtaskDto.getId());
        subtask.setAssignee(userRepository.findById(subtaskDto.getAssignee()).orElseThrow(() -> new NoSuchElementException("No user found by id : " + subtaskDto.getAssignee())));
        subtask.setSubtaskName(subtaskDto.getSubtaskName());
        subtask.setTask(taskRepository.findById(subtaskDto.getTask()).orElseThrow(() -> new NoSuchElementException("No task found by id : " + subtaskDto.getTask())));
        subtask.setTimeSpentInMinutes(subtaskDto.getTimeSpentInMinutes());
        subtask.setTaskStatus(subtaskDto.getTaskStatus());
        return subtask;
    }

    public SubtaskDto convert(Subtask subtask) {
        SubtaskDto subtaskDto = new SubtaskDto();
        subtaskDto.setId(subtask.getId());
        subtaskDto.setAssignee(subtask.getAssignee().getId());
        subtaskDto.setSubtaskName(subtask.getSubtaskName());
        subtaskDto.setTask(subtask.getTask().getId());
        subtaskDto.setTimeSpentInMinutes(subtask.getTimeSpentInMinutes());
        subtaskDto.setTaskStatus(subtask.getTaskStatus());
        return subtaskDto;
    }
}
