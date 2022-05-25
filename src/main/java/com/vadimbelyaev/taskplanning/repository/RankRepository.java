package com.vadimbelyaev.taskplanning.repository;

import com.vadimbelyaev.taskplanning.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RankRepository extends JpaRepository<Rank, UUID> {
}
