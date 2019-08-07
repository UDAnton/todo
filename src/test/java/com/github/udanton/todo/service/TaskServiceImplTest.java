package com.github.udanton.todo.service;

import com.github.udanton.todo.domain.Task;
import com.github.udanton.todo.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class TaskServiceImplTest {
    
    private static int ONE_TIME = 1;

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTasks() {

        List<Task> tasks = Arrays.asList(
                new Task(1L, "Make shopping", false),
                new Task(2L, "Make breakfast", false),
                new Task(3L, "Learn math", false)
        );

        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> tasksFromStorage = taskService.getTasks();

        assertEquals(tasks.size(), tasksFromStorage.size());

        verify(taskRepository, times(ONE_TIME)).findAll();
    }

    @Test
    public void getTaskById() {
        Task task = new Task(1L, "Make shopping", false);

        when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));

        Task taskFromStorage = taskService.getTaskById(1L);

        assertNotNull(taskFromStorage);
        assertEquals(task.getTextToDo(), taskFromStorage.getTextToDo());

        verify(taskRepository, times(ONE_TIME)).findById(anyLong());
    }

    @Test(expected = RuntimeException.class)
    public void getTaskByIdNotFound() {
        Optional<Task> task = Optional.empty();
        when(taskRepository.findById(anyLong())).thenReturn(task);
        taskService.getTaskById(1L);
        verify(taskRepository, times(1)).findById(anyLong());
    }

    @Test
    public void getTaskDone() {
        List<Task> tasks = Arrays.asList(
                new Task(1L, "Make shopping", true),
                new Task(2L, "Make breakfast", true)
        );

        when(taskRepository.findByDoneTrue()).thenReturn(tasks);

        List<Task> tasksFromStorage = taskService.getTaskDone();

        assertTrue(tasksFromStorage.get(0).isDone());

        verify(taskRepository, times(ONE_TIME)).findByDoneTrue();
    }

    @Test
    public void getTaskNotDone() {
        List<Task> tasks = Arrays.asList(
                new Task(1L, "Make shopping", false),
                new Task(2L, "Learn math", false)
        );

        when(taskRepository.findByDoneFalse()).thenReturn(tasks);

        List<Task> tasksFromStorage = taskService.getTaskNotDone();

        assertFalse(tasksFromStorage.get(0).isDone());

        verify(taskRepository, times(ONE_TIME)).findByDoneFalse();
    }

}