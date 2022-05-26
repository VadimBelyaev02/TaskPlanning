package com.vadimbelyaev.taskplanning.controller;

import com.vadimbelyaev.taskplanning.dto.UserDto;
import com.vadimbelyaev.taskplanning.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "User endpoints", description = "User RUD operations endpoints")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @Operation(summary = "Get User by its id")
    @ApiResponse(description = "User is found by its id", responseCode = "")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getById(@PathVariable("id") UUID id) {
        return service.getById(id);
    }

    @Operation(summary = "Get all Users")
    @ApiResponse(description = "All Users are found and returned", responseCode = "200")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers() {
        return service.getAll();
    }

    @Operation(summary = "Update an existed User")
    @ApiResponse(description = "An existed User is successfully updated and returned", responseCode = "200")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDto putUser(@RequestBody UserDto userDto) {
        return service.update(userDto);
    }

    @Operation(summary = "Delete an existed User")
    @ApiResponse(description = "An existed User is successfully deleted", responseCode = "204")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
}
