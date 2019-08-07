package com.github.udanton.todo.service;

import com.github.udanton.todo.domain.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    Task getTaskById(Long id);

    List<Task> getTaskDone();

    List<Task> getTaskNotDone();

}
