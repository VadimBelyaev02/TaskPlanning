package com.vadimbelyaev.taskplanning.controller;

import com.vadimbelyaev.taskplanning.dto.StatisticsDto;
import com.vadimbelyaev.taskplanning.service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Task endpoints", description = "Task CRUD operations endpoints")
@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final StatisticsService service;

    public StatisticsController(StatisticsService service) {
        this.service = service;
    }

    @Operation(summary = "Get a Statistics by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StatisticsDto getStatistics(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Operation(summary = "Get all Statistics")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StatisticsDto> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Add a new Statistics")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StatisticsDto postStatistics(@RequestBody StatisticsDto statisticsDto) {
        return service.save(statisticsDto);
    }

    @Operation(summary = "Update an existed Statistics")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public StatisticsDto putStatistics(@RequestBody StatisticsDto statisticsDto) {
        return service.update(statisticsDto);
    }

    @Operation(summary = "Delete an existed Statistics")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStatistics(@PathVariable("id") UUID id) {

    }
}
