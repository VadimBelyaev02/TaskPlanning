package com.vadimbelyaev.taskplanning.service.impl;

import com.vadimbelyaev.taskplanning.dto.UserDto;
import com.vadimbelyaev.taskplanning.dto.converter.UserConverter;
import com.vadimbelyaev.taskplanning.entity.User;
import com.vadimbelyaev.taskplanning.exception.NotFoundException;
import com.vadimbelyaev.taskplanning.repository.UserRepository;
import com.vadimbelyaev.taskplanning.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserConverter converter;
    private final UserRepository repository;

    public UserServiceImpl(UserConverter converter, UserRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserDto getById(UUID id) {
        User user = repository.findById(id).orElseThrow(() ->
                new NotFoundException("User with id = " + id + " is not found")
        );
        return converter.convertToDto(user);
    }

    @Override
    @Transactional
    public List<UserDto> getAll() {
        return repository.findAll().stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDto update(UserDto userDto) {
        if (repository.existsById(userDto.getId())) {
            throw new NotFoundException("User with id = " + userDto.getId() + " is not found");
        }
        User user = repository.save(converter.convertToEntity(userDto));
        return converter.convertToDto(user);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (repository.existsById(id)) {
            throw new NotFoundException("User with id = " + id + " is not found");
        }
        repository.deleteById(id);
    }
}
