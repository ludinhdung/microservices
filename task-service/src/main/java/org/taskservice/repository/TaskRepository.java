package org.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskservice.enitity.Task;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findByTitleIgnoreCase(String title);
}