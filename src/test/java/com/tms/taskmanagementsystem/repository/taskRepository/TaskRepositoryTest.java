package com.tms.taskmanagementsystem.repository.taskRepository;

import com.tms.taskmanagementsystem.domain.Task;
import com.tms.taskmanagementsystem.domain.TaskGroup;
import com.tms.taskmanagementsystem.domain.TaskStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository victim;

    @Test
    public void shouldCreateTask() {
        Task task = new Task();
        task.setTaskName("TEST_NAME");
        task.setTimeSpentInMinutes(0L);
        task.setTaskGroup(TaskGroup.Bug);
        task.setTaskStatus(TaskStatus.DevInProgress);

        Long result = victim.save(task).getId();

        assertThat(result).isNotNull();
    }

    @Test
    public void shouldFindTaskById() {
        Task task = new Task();
        task.setTaskName("TEST_NAME");
        task.setTimeSpentInMinutes(0L);
        task.setTaskGroup(TaskGroup.Bug);
        task.setTaskStatus(TaskStatus.DevInProgress);

        Long id = victim.save(task).getId();

        Optional<Task> result = victim.findById(id);

        assertThat(result).hasValue(expectedTask(id));
    }

    @Test
    public Task expectedTask(Long id) {
        Task task = new Task();
        task.setTaskName("TEST_NAME");
        task.setTimeSpentInMinutes(0L);
        task.setTaskGroup(TaskGroup.Bug);
        task.setTaskStatus(TaskStatus.DevInProgress);
        task.setId(id);
        return task;
    }
}
