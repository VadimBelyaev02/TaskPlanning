package com.vadimbelyaev.taskplanning.controller;

import com.vadimbelyaev.taskplanning.dto.RankDto;
import com.vadimbelyaev.taskplanning.service.RankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Rank endpoints", description = "Rank CRUD operations endpoints")
@RestController
@RequestMapping("/api/ranks")
public class RankController {

    private final RankService service;

    public RankController(RankService service) {
        this.service = service;
    }

    @Operation(summary = "Get Rank by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RankDto getRank(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Operation(summary = "Get all Ranks")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RankDto> getAllRanks() {
        return service.getAll();
    }

    @Operation(summary = "Add a new Rank")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RankDto postRank(@RequestBody RankDto rankDto) {
        return service.save(rankDto);
    }

    @Operation(summary = "Updated an existed Rank")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public RankDto putRank(@RequestBody RankDto rankDto) {
        return service.update(rankDto);
    }

    @Operation(summary = "Delete an existed Rank")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRank(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
