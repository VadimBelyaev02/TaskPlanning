package com.vadimbelyaev.taskplanning.service;

import com.vadimbelyaev.taskplanning.dto.RankDto;

import java.util.List;
import java.util.UUID;

public interface RankService {

    RankDto getById(UUID id);

    List<RankDto> getAll();

    RankDto save(RankDto rankDto);

    RankDto update(RankDto rankDto);

    void deleteById(UUID id);
}
