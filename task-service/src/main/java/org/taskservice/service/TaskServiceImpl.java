package org.taskservice.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.taskservice.dto.TaskDto;
import org.taskservice.dto.UserDto;
import org.taskservice.enitity.TaskDetail;
import org.taskservice.mapper.TaskMapper;
import org.taskservice.repository.TaskDetailRepository;
import org.taskservice.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskDetailRepository taskDetailRepository;
    private final APIClient apiClient;

    @Override
    public List<TaskDto> findAll() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @Override
    public TaskDto findById(Integer id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Override
    public TaskDto save(TaskDto taskDto) {

        UserDto userDto = apiClient.getUserById(taskDto.assignee());

        taskRepository.findByTitleIgnoreCase(taskDto.title())
                .ifPresent(task -> {
                    throw new RuntimeException("Task already exists with title: " + taskDto.title());
                });

        TaskDetail taskDetail = TaskAssignmentWrapper(taskDto, userDto);

        taskDetailRepository.save(taskDetail);

        return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(taskDto)));
    }

    private TaskDetail TaskAssignmentWrapper(TaskDto taskDto, UserDto userDto) {
        TaskDetail taskDetail = new TaskDetail();
        taskDetail.setTitle(taskDto.title());
        taskDetail.setDescription(taskDto.description());
        taskDetail.setCompleted(taskDto.completed());
        taskDetail.setAssigneeId(userDto.id());
        taskDetail.setAssigneeName(userDto.name());
        taskDetail.setAssigneeEmail(userDto.email());

        return taskDetail;
    }
}
