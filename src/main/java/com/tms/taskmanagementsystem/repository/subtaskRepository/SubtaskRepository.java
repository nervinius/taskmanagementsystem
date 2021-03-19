package com.tms.taskmanagementsystem.repository.subtaskRepository;

import com.tms.taskmanagementsystem.domain.Subtask;
import com.tms.taskmanagementsystem.domain.Task;
import com.tms.taskmanagementsystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtaskRepository extends JpaRepository<Subtask, Long> {

    boolean existsBySubtaskName(String subtaskName);

    List<Subtask> findAllByAssignee(User user);

    List<Subtask> findAllByTask(Task task);
}
