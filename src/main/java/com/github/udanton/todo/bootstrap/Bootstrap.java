package com.github.udanton.todo.bootstrap;

import com.github.udanton.todo.domain.Task;
import com.github.udanton.todo.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final TaskRepository taskRepository;

    public Bootstrap(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Task task1 = new Task("Learn Java", false);
        Task task2 = new Task("Learn Jenkins", false);
        Task task3 = new Task("Make a cup of coffee", true);
        Task task4 = new Task("Learn tests", false);
        Task task5 = new Task("To do sth", true);

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);
        taskRepository.save(task4);
        taskRepository.save(task5);
    }

}
