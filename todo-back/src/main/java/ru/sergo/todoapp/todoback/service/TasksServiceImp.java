package ru.sergo.todoapp.todoback.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergo.todoapp.todoback.entity.Task;
import ru.sergo.todoapp.todoback.interfaces.TasksService;
import ru.sergo.todoapp.todoback.repository.TodoTaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksServiceImp implements TasksService {

    private final TodoTaskRepository todoTaskRepository;

    @Override
    public Task addUserTask(Task taskInfo) {
        taskInfo = todoTaskRepository.save(taskInfo);
        return taskInfo;
    }

    @Override
    public List<Task> getSelfTasks() {
        //TODO get by username
        return todoTaskRepository.findAll();
    }

    @Override
    public List<Task> getAllTasks() {
        return todoTaskRepository.findAll();
    }
}
