package org.taskservice.service;


import org.taskservice.dto.TaskDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> findAll();
    TaskDto findById(Integer id);
    TaskDto save(TaskDto taskDto);
}
