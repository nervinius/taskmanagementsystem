package com.tms.taskmanagementsystem.dto;

import com.tms.taskmanagementsystem.domain.Task;
import com.tms.taskmanagementsystem.domain.TaskStatus;
import com.tms.taskmanagementsystem.domain.User;

import java.util.Objects;

public class SubtaskDto {

    private Long id;
    private String subtaskName;
    private Long timeSpentInMinutes;
    private Long assignee;
    private Long task;
    private TaskStatus taskStatus;

    public SubtaskDto() {
    }

    public SubtaskDto(Long id, String subtaskName, Long timeSpentInMinutes, Long assignee, Long task, TaskStatus taskStatus) {
        this.id = id;
        this.subtaskName = subtaskName;
        this.timeSpentInMinutes = timeSpentInMinutes;
        this.assignee = assignee;
        this.task = task;
        this.taskStatus = taskStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public void setSubtaskName(String subtaskName) {
        this.subtaskName = subtaskName;
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

    public Long getTask() {
        return task;
    }

    public void setTask(Long task) {
        this.task = task;
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
        SubtaskDto that = (SubtaskDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(subtaskName, that.subtaskName) &&
                Objects.equals(timeSpentInMinutes, that.timeSpentInMinutes) &&
                Objects.equals(assignee, that.assignee) &&
                Objects.equals(task, that.task) &&
                taskStatus == that.taskStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subtaskName, timeSpentInMinutes, assignee, task, taskStatus);
    }

    @Override
    public String toString() {
        return "SubtaskDto{" +
                "id=" + id +
                ", subtaskName='" + subtaskName + '\'' +
                ", timeSpentInMinutes=" + timeSpentInMinutes +
                ", assignee=" + assignee +
                ", task=" + task +
                ", taskStatus=" + taskStatus +
                '}';
    }

    public interface Update {
        // empty interface
    }

    public interface Create {
        // empty interface
    }
}
