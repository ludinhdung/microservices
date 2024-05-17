package org.taskservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.taskservice.dto.TaskDto;
import org.taskservice.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskDto findById(@PathVariable Integer id) {
        return taskService.findById(id);
    }

    @PostMapping
    public TaskDto save(@RequestBody @Valid TaskDto taskDto) {
        return taskService.save(taskDto);
    }

}
