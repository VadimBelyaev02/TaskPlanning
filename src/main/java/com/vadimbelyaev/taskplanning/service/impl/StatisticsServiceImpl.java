package com.vadimbelyaev.taskplanning.service.impl;

import com.vadimbelyaev.taskplanning.dto.StatisticsDto;
import com.vadimbelyaev.taskplanning.dto.converter.StatisticsConverter;
import com.vadimbelyaev.taskplanning.entity.Statistics;
import com.vadimbelyaev.taskplanning.exception.AlreadyExistsException;
import com.vadimbelyaev.taskplanning.exception.NotFoundException;
import com.vadimbelyaev.taskplanning.repository.StatisticsRepository;
import com.vadimbelyaev.taskplanning.service.StatisticsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository repository;
    private final StatisticsConverter converter;

    public StatisticsServiceImpl(StatisticsRepository repository, StatisticsConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    @Transactional
    public StatisticsDto getById(UUID id) {
        Statistics statistics = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Statistics with id = " + id + " is not found")
        );
        return converter.convertToDto(statistics);
    }

    @Override
    @Transactional
    public List<StatisticsDto> getAll() {
        return repository.findAll().stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public StatisticsDto save(StatisticsDto statisticsDto) {
        if (repository.existsById(statisticsDto.getId())) {
            throw new AlreadyExistsException("Statistics with id = " + statisticsDto.getId() + " already exists");
        }
        Statistics statistics = repository.save(converter.convertToEntity(statisticsDto));
        return converter.convertToDto(statistics);
    }

    @Override
    @Transactional
    public StatisticsDto update(StatisticsDto statisticsDto) {
        if (!repository.existsById(statisticsDto.getId())) {
            throw new NotFoundException("Statistics with id = " + statisticsDto.getId() + " is not found");
        }
        Statistics statistics = repository.save(converter.convertToEntity(statisticsDto));
        return converter.convertToDto(statistics);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Statistics with id = " + id + " is not found");
        }
        repository.deleteById(id);
    }
}
