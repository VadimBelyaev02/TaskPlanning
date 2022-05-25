package com.vadimbelyaev.taskplanning.repository;

import com.vadimbelyaev.taskplanning.entity.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConfirmationRepository extends JpaRepository<Confirmation, UUID> {
}
