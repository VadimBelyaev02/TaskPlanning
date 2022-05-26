package com.vadimbelyaev.taskplanning.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskDto {

    private UUID id;

    private LocalDateTime dateTime;

    @NotNull
    private String topic;

    private String description;

    @NotNull
    private UUID userId;

    @NotNull
    private Integer score;
}
