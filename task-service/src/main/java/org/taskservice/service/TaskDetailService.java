package org.taskservice.service;

import org.taskservice.dto.TaskDetailDto;

import java.util.List;

public interface TaskDetailService {

    List<TaskDetailDto> getAll();
    TaskDetailDto getById(Integer id);
    TaskDetailDto save(TaskDetailDto taskDetailDto);
}
