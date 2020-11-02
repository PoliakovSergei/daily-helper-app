package ru.sergo.todoapp.todoback.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.sergo.todoapp.todoback.dto.BaseResponse;
import ru.sergo.todoapp.todoback.dto.TodoTaskDto;
import ru.sergo.todoapp.todoback.interfaces.TasksService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TodoTasksController {

    private final TasksService tasksService;

    @GetMapping("/my-tasks")
    @CrossOrigin(origins = "*")
    BaseResponse getUserTasks() {
        log.info("Getting userle tasks");
        return new BaseResponse(tasksService.getUserTasks());
    }

    @PostMapping("/add-task")
    TodoTaskDto addUserTask(@RequestBody TodoTaskDto taskInfo) {
        log.info("Adding user task");
        return tasksService.addUserTask(taskInfo);
    }
}
