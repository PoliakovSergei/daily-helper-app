package ru.sergo.todoapp.todoback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergo.todoapp.todoback.dto.Response;
import ru.sergo.todoapp.todoback.dto.Response.ResponseBuilder;
import ru.sergo.todoapp.todoback.entity.Task;
import ru.sergo.todoapp.todoback.interfaces.TasksService;
import ru.sergo.todoapp.todoback.repository.TodoTaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksServiceImp implements TasksService {

    private final TodoTaskRepository todoTaskRepository;

    @Override
    public Response<Task> addUserTask(Task taskInfo) {
        taskInfo = todoTaskRepository.save(taskInfo);
        return ResponseBuilder.ok(taskInfo);
    }

    @Override
    public Response<List<Task>> getSelfTasks() {
        //TODO get by username
        List<Task> resultTasks = todoTaskRepository.findAll();
        return ResponseBuilder.ok(resultTasks);
    }

    @Override
    public Response<List<Task>> getAllTasks() {
        List<Task> resultTasks = todoTaskRepository.findAll();
        return ResponseBuilder.ok(resultTasks);
    }
}
