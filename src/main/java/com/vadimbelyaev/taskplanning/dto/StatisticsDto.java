package com.vadimbelyaev.taskplanning.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StatisticsDto {

    private UUID id;

    @NotNull
    private Integer completed;

    @NotNull
    private Integer unfulfilled;

    @NotNull
    private Integer overdue;

    @NotNull
    private Integer totalScore;

    @NotNull
    private UUID userId;
}
