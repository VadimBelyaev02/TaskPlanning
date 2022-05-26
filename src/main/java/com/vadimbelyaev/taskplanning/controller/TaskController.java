package com.vadimbelyaev.taskplanning.controller;

import com.vadimbelyaev.taskplanning.dto.TaskDto;
import com.vadimbelyaev.taskplanning.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @ApiResponse(description = "A new Task is found and returned", responseCode = "")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDto getTask(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Operation(summary = "Get all Tasks")
    @ApiResponse(description = "All Tasks are found and returned", responseCode = "200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDto> getAllTasks() {
        return service.getAll();
    }

    @Operation(summary = "Add a new Task")
    @ApiResponse(description = "A new Task is successfully saved and returned", responseCode = "201")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto postTask(@RequestBody TaskDto taskDto) {
        return service.save(taskDto);
    }

    @Operation(summary = "Updated an existed Task")
    @ApiResponse(description = "An existed Task is successfully updated and returned", responseCode = "200")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public TaskDto putTask(@RequestBody TaskDto taskDto) {
        return service.update(taskDto);
    }

    @Operation(summary = "Delete an existed Task")
    @ApiResponse(description = "An existed Task is successfully deleted", responseCode = "204")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
