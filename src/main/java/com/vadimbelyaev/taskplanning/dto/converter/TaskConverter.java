package com.vadimbelyaev.taskplanning.dto.converter;

import com.vadimbelyaev.taskplanning.dto.TaskDto;
import com.vadimbelyaev.taskplanning.entity.Task;
import com.vadimbelyaev.taskplanning.entity.User;
import com.vadimbelyaev.taskplanning.exception.NotFoundException;
import com.vadimbelyaev.taskplanning.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class TaskConverter {

    private final UserRepository userRepository;

    public TaskConverter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Task convertToEntity(TaskDto taskDto) {
        UUID id = taskDto.getId();
        LocalDateTime dateTime = taskDto.getDateTime();
        String topic = taskDto.getTopic();
        String description = taskDto.getDescription();

        User user = userRepository.findById(taskDto.getUserId()).orElseThrow(() ->
                new NotFoundException("User with id = " + taskDto.getUserId() + " is not found")
        );

        return Task.builder()
                .id(id)
                .dateTime(dateTime)
                .topic(topic)
                .description(description)
                .user(user)
                .build();
    }

    public TaskDto convertToDto(Task task) {
        UUID id = task.getId();
        LocalDateTime dateTime = task.getDateTime();
        String topic = task.getTopic();
        String description = task.getDescription();
        UUID userId = task.getUser().getId();

        return TaskDto.builder()
                .id(id)
                .dateTime(dateTime)
                .topic(topic)
                .description(description)
                .userId(userId)
                .build();
    }
}
