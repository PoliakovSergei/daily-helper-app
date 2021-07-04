package ru.sergo.todoapp.todoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sergo.todoapp.todoback.entity.Task;

import java.util.UUID;

@Repository
public interface TodoTaskRepository extends JpaRepository<Task, UUID> {
}
