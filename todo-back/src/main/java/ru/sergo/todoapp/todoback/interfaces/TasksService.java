package ru.sergo.todoapp.todoback.interfaces;

import ru.sergo.todoapp.todoback.entity.Task;

import java.util.List;

public interface TasksService {
    Task addUserTask(Task taskInfo);
    List<Task> getSelfTasks();
    List<Task> getAllTasks();
}
