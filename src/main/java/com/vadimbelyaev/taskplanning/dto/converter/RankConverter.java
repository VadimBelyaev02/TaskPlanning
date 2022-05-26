package com.vadimbelyaev.taskplanning.dto.converter;

import com.vadimbelyaev.taskplanning.dto.RankDto;
import com.vadimbelyaev.taskplanning.entity.Rank;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RankConverter {

    public Rank convertToEntity(RankDto rankDto) {
        UUID id = rankDto.getId();
        Integer requiredScore = rankDto.getRequiredScore();
        String name = rankDto.getName();
        String color = rankDto.getColor();

        return Rank.builder()
                .id(id)
                .requiredScore(requiredScore)
                .name(name)
                .color(color)
                .build();
    }

    public RankDto convertToDto(Rank rank) {
        UUID id = rank.getId();
        Integer requiredScore = rank.getRequiredScore();
        String color = rank.getColor();
        String name = rank.getName();

        return RankDto.builder()
                .id(id)
                .requiredScore(requiredScore)
                .color(color)
                .name(name)
                .build();
    }
}
