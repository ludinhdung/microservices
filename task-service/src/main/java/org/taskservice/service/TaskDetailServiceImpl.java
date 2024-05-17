package org.taskservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.taskservice.dto.TaskDetailDto;
import org.taskservice.mapper.TaskDetailMapper;
import org.taskservice.repository.TaskDetailRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskDetailServiceImpl implements TaskDetailService {

    private final TaskDetailRepository taskDetailRepository;
    private final TaskDetailMapper taskDetailMapper;

    @Override
    public List<TaskDetailDto> getAll() {
        return taskDetailRepository.findAll().stream()
                .map(taskDetailMapper::toDto)
                .toList();
    }

    @Override
    public TaskDetailDto getById(Integer id) {
        return taskDetailRepository.findById(id)
                .map(taskDetailMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Override
    public TaskDetailDto save(TaskDetailDto taskDetailDto) {
        taskDetailRepository.findById(taskDetailDto.id())
                .ifPresent(taskDetail -> {
                    throw new RuntimeException("Task already exists with id: " + taskDetailDto.id());
                });
        return taskDetailMapper.toDto(taskDetailRepository.save(taskDetailMapper.toEntity(taskDetailDto)));
    }
}
