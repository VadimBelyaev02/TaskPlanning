package com.vadimbelyaev.taskplanning.dto.converter;

import com.vadimbelyaev.taskplanning.dto.StatisticsDto;
import com.vadimbelyaev.taskplanning.entity.Statistics;
import com.vadimbelyaev.taskplanning.entity.User;
import com.vadimbelyaev.taskplanning.exception.NotFoundException;
import com.vadimbelyaev.taskplanning.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StatisticsConverter {

    private final UserRepository repository;

    public StatisticsConverter(UserRepository repository) {
        this.repository = repository;
    }

    public Statistics convertToEntity(StatisticsDto statisticsDto) {
        UUID id = statisticsDto.getId();
        Integer completed = statisticsDto.getCompleted();
        Integer unfulfilled = statisticsDto.getUnfulfilled();
        Integer overdue = statisticsDto.getOverdue();
        Integer totalScore = statisticsDto.getTotalScore();

        User user = repository.findById(statisticsDto.getUserId()).orElseThrow(() ->
                new NotFoundException("User with id = " + statisticsDto.getUserId() + " is not found")
        );

        return Statistics.builder()
                .id(id)
                .completed(completed)
                .unfulfilled(unfulfilled)
                .overdue(overdue)
                .totalScore(totalScore)
                .user(user)
                .build();
    }

    public StatisticsDto convertToDto(Statistics statistics) {
        UUID id = statistics.getId();
        Integer completed = statistics.getCompleted();
        Integer unfulfilled = statistics.getUnfulfilled();
        Integer overdue = statistics.getOverdue();
        Integer totalScore = statistics.getTotalScore();
        UUID userId = statistics.getUser().getId();

        return StatisticsDto.builder()
                .id(id)
                .completed(completed)
                .unfulfilled(unfulfilled)
                .overdue(overdue)
                .totalScore(totalScore)
                .userId(userId)
                .build();
    }
}
