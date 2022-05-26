package com.vadimbelyaev.taskplanning.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RankDto {

    private UUID id;

    @NotNull
    private Integer requiredScore;

    @NotNull
    private String name;

    @NotNull
    private String color;
}
