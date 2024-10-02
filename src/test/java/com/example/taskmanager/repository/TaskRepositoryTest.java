package com.example.taskmanager.repository;

import com.example.taskmanager.entity.Task;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testCreateAndFindTask() {
        Task task = new Task();
        task.setTaskName("Test Task");
        task.setTaskDescription("Test Description");
        task.setTaskStatus(Task.TaskStatus.NEW);

        taskRepository.save(task);

        Task found = taskRepository.findById(task.getId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getTaskName()).isEqualTo("Test Task");
    }
}
