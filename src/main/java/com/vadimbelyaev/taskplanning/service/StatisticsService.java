package com.vadimbelyaev.taskplanning.service;

import com.vadimbelyaev.taskplanning.dto.StatisticsDto;

import java.util.List;
import java.util.UUID;

public interface StatisticsService {

    StatisticsDto getById(UUID id);

    List<StatisticsDto> getAll();

    StatisticsDto save(StatisticsDto statisticsDto);

    StatisticsDto update(StatisticsDto statisticsDto);

    void deleteById(UUID id);
}
