package ru.sergo.todoapp.todoback.interfaces;

import ru.sergo.todoapp.todoback.dto.TodoTaskDto;

import java.util.List;

public interface TasksService {
    TodoTaskDto addUserTask(TodoTaskDto taskInfo);
    List<TodoTaskDto> getUserTasks();
}
