package com.github.udanton.todo.controller;

import com.github.udanton.todo.domain.Task;
import com.github.udanton.todo.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> findAll() {
        return taskService.getTasks();
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Task findById(@PathVariable String id) {
        return taskService.getTaskById(Long.valueOf(id));
    }


    @GetMapping(
            params = {"done"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Task> findByDone(@RequestParam(value = "done") boolean done) {
        return done ? taskService.getTaskDone() : taskService.getTaskNotDone();
    }

}
