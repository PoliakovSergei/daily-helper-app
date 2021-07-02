package ru.sergo.todoapp.todoback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sergo.todoapp.todoback.aspect.LoggerAspect.LogBefore;
import ru.sergo.todoapp.todoback.dto.Response;
import ru.sergo.todoapp.todoback.entity.Task;
import ru.sergo.todoapp.todoback.interfaces.TasksService;

import java.util.List;

@LogBefore
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TodoTasksController {

    private final TasksService tasksService;

    @GetMapping("/my-tasks")
    public Response<List<Task>> getUserTasks() {
        return tasksService.getSelfTasks();
    }

    @GetMapping("/all")
    public Response<List<Task>> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @PostMapping("/add-task")
    public Response<Task> addUserTask(@RequestBody Task taskInfo) {
        return tasksService.addUserTask(taskInfo);
    }
}
