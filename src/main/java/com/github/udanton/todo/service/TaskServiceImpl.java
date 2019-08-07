package com.github.udanton.todo.service;

import com.github.udanton.todo.domain.Task;
import com.github.udanton.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Override
    public List<Task> getTaskDone() {
        return taskRepository.findByDoneTrue();
    }

    @Override
    public List<Task> getTaskNotDone() {
        return taskRepository.findByDoneFalse();
    }

}
