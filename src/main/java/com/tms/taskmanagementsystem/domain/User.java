package com.tms.taskmanagementsystem.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "assignee")
    @JsonManagedReference
    private Set<Task> tasks;
    @OneToMany(mappedBy = "assignee")
    private Set<Subtask> subtasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(Set<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(tasks, user.tasks) &&
                Objects.equals(subtasks, user.subtasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, tasks, subtasks);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tasks=" + tasks +
                ", subtasks=" + subtasks +
                '}';
    }
}
