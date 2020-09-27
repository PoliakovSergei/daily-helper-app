package ru.sergo.todoapp.todoback.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TodoTaskDto {

    private final String taskName;

    private final String taskDescription;

    private final Date endDate;

}
