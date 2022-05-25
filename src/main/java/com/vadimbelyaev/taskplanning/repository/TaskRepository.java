package com.vadimbelyaev.taskplanning.repository;

import com.vadimbelyaev.taskplanning.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
