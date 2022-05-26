package com.vadimbelyaev.taskplanning.service;

import com.vadimbelyaev.taskplanning.dto.TaskDto;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    TaskDto getById(UUID id);

    List<TaskDto> getAll();

    TaskDto save(TaskDto taskDto);

    TaskDto update(TaskDto taskDto);

    void deleteById(UUID id);
}
