package com.github.udanton.todo.repository;

import com.github.udanton.todo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDoneTrue();

    List<Task> findByDoneFalse();

}
