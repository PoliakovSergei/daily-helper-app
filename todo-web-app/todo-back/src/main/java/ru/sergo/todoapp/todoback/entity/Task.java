package ru.sergo.todoapp.todoback.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "TASKS", schema = "todo_app")
@NoArgsConstructor
public class Task {

    @Id
    @Column(name = "ID")
    private final UUID id = UUID.randomUUID();

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "TASK_DESCRIPTION")
    private String taskDescription;

    @Column(name = "END_DATE")
    private Date endDate;

}
