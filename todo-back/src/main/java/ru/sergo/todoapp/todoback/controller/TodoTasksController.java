package ru.sergo.todoapp.todoback.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sergo.todoapp.todoback.dto.BaseResponse;
import ru.sergo.todoapp.todoback.entity.Task;
import ru.sergo.todoapp.todoback.interfaces.TasksService;

@Slf4j
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TodoTasksController {

    private final TasksService tasksService;

    @GetMapping("/my-tasks")
    @CrossOrigin(origins = "*")
    BaseResponse getUserTasks() {
        log.info("Get user tasks request");
        return new BaseResponse(tasksService.getSelfTasks());
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    BaseResponse getAllTasks() {
        log.info("Get all tasks request");
        return new BaseResponse(tasksService.getAllTasks());
    }

    @PostMapping("/add-task")
    Task addUserTask(@RequestBody Task taskInfo) {
        log.info("Adding user task");
        return tasksService.addUserTask(taskInfo);
    }
}
