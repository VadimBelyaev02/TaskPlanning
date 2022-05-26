package com.vadimbelyaev.taskplanning.controller;

import com.vadimbelyaev.taskplanning.dto.UserDto;
import com.vadimbelyaev.taskplanning.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "User endpoints", description = "User CRUD operations endpoints")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @Operation(summary = "Get User by its id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Operation(summary = "Get all Users")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers() {
        return service.getAll();
    }

    @Operation(summary = "Update an existed User")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDto putUser(@RequestBody UserDto userDto) {
        return service.update(userDto);
    }

    @Operation(summary = "Delete an existed User")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
