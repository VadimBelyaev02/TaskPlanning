package com.vadimbelyaev.taskplanning.service.impl;

import com.vadimbelyaev.taskplanning.dto.TaskDto;
import com.vadimbelyaev.taskplanning.dto.converter.TaskConverter;
import com.vadimbelyaev.taskplanning.entity.Task;
import com.vadimbelyaev.taskplanning.exception.AlreadyExistsException;
import com.vadimbelyaev.taskplanning.exception.NotFoundException;
import com.vadimbelyaev.taskplanning.repository.TaskRepository;
import com.vadimbelyaev.taskplanning.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskConverter converter;

    public TaskServiceImpl(TaskRepository repository, TaskConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    @Transactional
    public TaskDto getById(UUID id) {
        Task task = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Task with id = " + id + " is not found")
        );
        return converter.convertToDto(task);
    }

    @Override
    @Transactional
    public List<TaskDto> getAll() {
        return repository.findAll().stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TaskDto save(TaskDto taskDto) {
        if (repository.existsById(taskDto.getId())) {
            throw new AlreadyExistsException("Task with id = " + taskDto.getId() + " already exists");
        }
        Task task = repository.save(converter.convertToEntity(taskDto));
        return converter.convertToDto(task);
    }

    @Override
    @Transactional
    public TaskDto update(TaskDto taskDto) {
        if (!repository.existsById(taskDto.getId())) {
            throw new NotFoundException("Task with id = " + taskDto.getId() + " is not found");
        }
        Task task = repository.save(converter.convertToEntity(taskDto));
        return converter.convertToDto(task);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Task with id = " + id + " is not found");
        }
        repository.deleteById(id);
    }
}
