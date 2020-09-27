package ru.sergo.todoapp.todoback.service;

import org.springframework.stereotype.Service;
import ru.sergo.todoapp.todoback.dto.TodoTaskDto;
import ru.sergo.todoapp.todoback.interfaces.TasksService;

import java.util.Date;
import java.util.List;

@Service
public class TasksServiceImp implements TasksService {
    @Override
    public TodoTaskDto addUserTask(TodoTaskDto taskInfo) {
        //TODO add user new task to DB
        return taskInfo;
    }

    @Override
    public List<TodoTaskDto> getUserTasks() {
        //TODO get user tasks from DB
        return List.of(
                new TodoTaskDto("first task name", "first task description", new Date()),
                new TodoTaskDto("second task name", "second task description", new Date()),
                new TodoTaskDto("third task name", "third task description", new Date())
        );
    }
}
