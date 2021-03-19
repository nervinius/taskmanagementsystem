package com.tms.taskmanagementsystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "task_name")
    private String taskName;
    @Enumerated(EnumType.STRING)
    @Column(name = "task_group")
    private TaskGroup taskGroup;
    @Enumerated(EnumType.STRING)
    @Column(name = "task_status")
    private TaskStatus taskStatus;
    @Column(name = "time_spent_minutes")
    private Long timeSpentInMinutes;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User assignee;
    @OneToMany(mappedBy = "task")
    private Set<Subtask> subtasks;

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

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Set<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(Set<Subtask> subtasks) {
        this.subtasks = subtasks;
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
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(taskName, task.taskName) &&
                taskGroup == task.taskGroup &&
                taskStatus == task.taskStatus &&
                Objects.equals(timeSpentInMinutes, task.timeSpentInMinutes) &&
                Objects.equals(assignee, task.assignee) &&
                Objects.equals(subtasks, task.subtasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskName, taskGroup, taskStatus, timeSpentInMinutes, assignee, subtasks);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskGroup=" + taskGroup +
                ", taskStatus=" + taskStatus +
                ", timeSpentInMinutes=" + timeSpentInMinutes +
                ", assignee=" + assignee +
                ", subtasks=" + subtasks +
                '}';
    }
}
