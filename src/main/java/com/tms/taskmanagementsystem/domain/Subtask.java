package com.tms.taskmanagementsystem.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subtasks")
public class Subtask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subtask_id")
    private Long id;
    @Column(name = "task_name")
    private String subtaskName;
    @Column(name = "time_spent_minutes")
    private Long timeSpentInMinutes;
    @Enumerated(EnumType.STRING)
    @Column(name = "task_status")
    private TaskStatus taskStatus;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User assignee;
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

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

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
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
        Subtask subtask = (Subtask) o;
        return Objects.equals(id, subtask.id) &&
                Objects.equals(subtaskName, subtask.subtaskName) &&
                Objects.equals(timeSpentInMinutes, subtask.timeSpentInMinutes) &&
                taskStatus == subtask.taskStatus &&
                Objects.equals(assignee, subtask.assignee) &&
                Objects.equals(task, subtask.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subtaskName, timeSpentInMinutes, taskStatus, assignee, task);
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + id +
                ", subtaskName='" + subtaskName + '\'' +
                ", timeSpentInMinutes=" + timeSpentInMinutes +
                ", taskStatus=" + taskStatus +
                ", assignee=" + assignee +
                ", task=" + task +
                '}';
    }
}
