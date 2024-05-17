package org.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskservice.enitity.TaskDetail;

public interface TaskDetailRepository extends JpaRepository<TaskDetail, Integer> {
}