package com.tms.taskmanagementsystem.repository.taskRepository;

import com.tms.taskmanagementsystem.domain.Task;
import com.tms.taskmanagementsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    boolean existsByTaskName(String taskName);
    List<Task> findAllByAssignee(User user);

}
