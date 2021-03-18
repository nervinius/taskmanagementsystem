package com.tms.taskmanagementsystem.dto;

import com.tms.taskmanagementsystem.domain.TaskGroup;
import com.tms.taskmanagementsystem.domain.TaskStatus;
import com.tms.taskmanagementsystem.domain.User;

import java.util.Objects;

public class TaskDto {

    private Long id;
    private String taskName;
    private TaskGroup taskGroup;
    private TaskStatus taskStatus;
    private Long timeSpentInMinutes;
    private Long assignee;

    public TaskDto() {
    }

    public TaskDto(Long id, String taskName, TaskGroup taskGroup, TaskStatus taskStatus, Long timeSpentInMinutes, Long assignee) {
        this.id = id;
        this.taskName = taskName;
        this.taskGroup = taskGroup;
        this.taskStatus = taskStatus;
        this.timeSpentInMinutes = timeSpentInMinutes;
        this.assignee = assignee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskGroup getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }

    public Long getTimeSpentInMinutes() {
        return timeSpentInMinutes;
    }

    public void setTimeSpentInMinutes(Long timeSpentInMinutes) {
        this.timeSpentInMinutes = timeSpentInMinutes;
    }

    public Long getAssignee() {
        return assignee;
    }

    public void setAssignee(Long assignee) {
        this.assignee = assignee;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto taskDto = (TaskDto) o;
        return Objects.equals(id, taskDto.id) &&
                Objects.equals(taskName, taskDto.taskName) &&
                taskGroup == taskDto.taskGroup &&
                taskStatus == taskDto.taskStatus &&
                Objects.equals(timeSpentInMinutes, taskDto.timeSpentInMinutes) &&
                Objects.equals(assignee, taskDto.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskName, taskGroup, taskStatus, timeSpentInMinutes, assignee);
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskGroup=" + taskGroup +
                ", taskStatus=" + taskStatus +
                ", timeSpentInMinutes=" + timeSpentInMinutes +
                ", assignee=" + assignee +
                '}';
    }

    public interface Update {
        // empty interface
    }

    public interface Create {
        // empty interface
    }
}
