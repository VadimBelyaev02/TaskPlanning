package com.vadimbelyaev.taskplanning.service.impl;

import com.vadimbelyaev.taskplanning.dto.RankDto;
import com.vadimbelyaev.taskplanning.dto.converter.RankConverter;
import com.vadimbelyaev.taskplanning.entity.Rank;
import com.vadimbelyaev.taskplanning.exception.AlreadyExistsException;
import com.vadimbelyaev.taskplanning.exception.NotFoundException;
import com.vadimbelyaev.taskplanning.repository.RankRepository;
import com.vadimbelyaev.taskplanning.service.RankService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RankServiceImpl implements RankService {

    private final RankRepository repository;
    private final RankConverter converter;

    public RankServiceImpl(RankRepository repository, RankConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }


    @Override
    @Transactional
    public RankDto getById(UUID id) {
        Rank rank = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Rank with id = " + id + " is not found")
        );
        return converter.convertToDto(rank);
    }

    @Override
    @Transactional
    public List<RankDto> getAll() {
        return repository.findAll().stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RankDto save(RankDto rankDto) {
        if (repository.existsById(rankDto.getId())) {
            throw new AlreadyExistsException("Rank with id = " + rankDto.getId() + " already exists");
        }
        Rank rank = repository.save(converter.convertToEntity(rankDto));
        return converter.convertToDto(rank);
    }

    @Override
    @Transactional
    public RankDto update(RankDto rankDto) {
        if (!repository.existsById(rankDto.getId())) {
            throw new NotFoundException("Rank with id = " + rankDto.getId() + " is not found");
        }
        Rank rank = repository.save(converter.convertToEntity(rankDto));
        return converter.convertToDto(rank);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Rank with id = " + id + " is not found");
        }
        repository.deleteById(id);
    }
}
