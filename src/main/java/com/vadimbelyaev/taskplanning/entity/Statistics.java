package com.vadimbelyaev.taskplanning.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "completed")
    private Integer completed;

    @Column(name = "unfulfilled")
    private Integer unfulfilled;

    @Column(name = "overdue")
    private Integer overdue;

    @Column(name = "total_score")
    private Integer totalScore;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
