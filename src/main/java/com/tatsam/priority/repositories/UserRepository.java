package com.tatsam.priority.repositories;

import com.tatsam.priority.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
