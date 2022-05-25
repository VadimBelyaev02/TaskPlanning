package com.vadimbelyaev.taskplanning.service;

import com.vadimbelyaev.taskplanning.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDto getById(UUID id);

    List<UserDto> getAll();

    UserDto update(UserDto userDto);

    void deleteById(UUID id);
}
