package com.vadimbelyaev.taskplanning.repository;

import com.vadimbelyaev.taskplanning.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatisticsRepository extends JpaRepository<Statistics, UUID> {
}
