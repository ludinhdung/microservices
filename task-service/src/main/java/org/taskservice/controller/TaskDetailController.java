package org.taskservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.taskservice.dto.TaskDetailDto;
import org.taskservice.service.TaskDetailService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task-details")
public class TaskDetailController {

    private final TaskDetailService taskDetailService;

    @GetMapping
    public List<TaskDetailDto> getAll() {
        return taskDetailService.getAll();
    }

    @GetMapping("/{id}")
    public TaskDetailDto getById(@PathVariable Integer id) {
        return taskDetailService.getById(id);
    }

    @PostMapping
    public TaskDetailDto save(@RequestBody @Valid TaskDetailDto taskDetailDto) {
        return taskDetailService.save(taskDetailDto);
    }

}
