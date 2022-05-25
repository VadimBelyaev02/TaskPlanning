package com.vadimbelyaev.taskplanning.dto;

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

    private String topic;

    private String description;

    private UUID userId;

    private Integer score;
}
