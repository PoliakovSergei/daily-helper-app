package ru.sergo.todoapp.todoback.interfaces;

import ru.sergo.todoapp.todoback.dto.Response;
import ru.sergo.todoapp.todoback.entity.Task;

import java.util.List;

public interface TasksService {
    Response<Task> addUserTask(Task taskInfo);
    Response<List<Task>> getSelfTasks();
    Response<List<Task>> getAllTasks();
}
