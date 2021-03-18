package com.tms.taskmanagementsystem.repository.subtaskRepository;

import com.tms.taskmanagementsystem.domain.Subtask;
import com.tms.taskmanagementsystem.domain.Task;
import com.tms.taskmanagementsystem.domain.TaskGroup;
import com.tms.taskmanagementsystem.domain.TaskStatus;
import com.tms.taskmanagementsystem.repository.taskRepository.TaskRepository;
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
public class SubtaskRepositoryTest {

    @Autowired
    private SubtaskRepository victim;

    @Test
    public void shouldCreateTask() {
        Subtask subtask = new Subtask();
        subtask.setSubtaskName("TEST_NAME");
        subtask.setTimeSpentInMinutes(0L);
        subtask.setTaskStatus(TaskStatus.DevInProgress);

        Long result = victim.save(subtask).getId();

        assertThat(result).isNotNull();
    }

    @Test
    public void shouldFindTaskById() {
        Subtask subtask = new Subtask();
        subtask.setSubtaskName("TEST_NAME");
        subtask.setTimeSpentInMinutes(0L);
        subtask.setTaskStatus(TaskStatus.DevInProgress);

        Long id = victim.save(subtask).getId();

        Optional<Subtask> result = victim.findById(id);

        assertThat(result).hasValue(expectedSubtask(id));
    }

    @Test
    public Subtask expectedSubtask(Long id) {
        Subtask subtask = new Subtask();
        subtask.setSubtaskName("TEST_NAME");
        subtask.setTimeSpentInMinutes(0L);
        subtask.setTaskStatus(TaskStatus.DevInProgress);
        subtask.setId(id);
        return subtask;
    }
}
