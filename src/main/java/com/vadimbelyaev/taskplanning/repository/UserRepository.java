package com.vadimbelyaev.taskplanning.repository;

import com.vadimbelyaev.taskplanning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


}
