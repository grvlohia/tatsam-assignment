package com.tatsam.priority.repositories;

import com.tatsam.priority.entities.Priority;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
    
}
