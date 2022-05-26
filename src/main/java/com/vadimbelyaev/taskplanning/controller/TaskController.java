package com.vadimbelyaev.taskplanning.controller;

import com.vadimbelyaev.taskplanning.dto.TaskDto;
import com.vadimbelyaev.taskplanning.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Task endpoints", description = "Task CRUD operations endpoints")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @Operation(summary = "Get Task by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDto getTask(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Operation(summary = "Get all Tasks")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDto> getAllTasks() {
        return service.getAll();
    }

    @Operation(summary = "Add a new Task")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto postTask(@RequestBody TaskDto taskDto) {
        return service.save(taskDto);
    }

    @Operation(summary = "Updated an existed Task")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public TaskDto putTask(@RequestBody TaskDto taskDto) {
        return service.update(taskDto);
    }

    @Operation(summary = "Delete an existed Task")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
