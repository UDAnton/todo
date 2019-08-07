package com.github.udanton.todo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "text_to_do")
    private String textToDo;

    private boolean done;

    public Task() {
    }

    public Task(@NotBlank String textToDo, boolean done) {
        this.textToDo = textToDo;
        this.done = done;
    }

    public Task(Long id, @NotBlank String textToDo, boolean done) {
        this.id = id;
        this.textToDo = textToDo;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextToDo() {
        return textToDo;
    }

    public void setTextToDo(String textToDo) {
        this.textToDo = textToDo;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return done == task.done &&
                Objects.equals(id, task.id) &&
                Objects.equals(textToDo, task.textToDo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, textToDo, done);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", textToDo='" + textToDo + '\'' +
                ", done=" + done +
                '}';
    }
}
