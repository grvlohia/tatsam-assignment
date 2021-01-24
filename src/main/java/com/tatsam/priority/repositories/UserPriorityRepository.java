package com.tatsam.priority.repositories;

import com.tatsam.priority.entities.UserPriority;
import com.tatsam.priority.entities.UserPriorityId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPriorityRepository extends JpaRepository<UserPriority, UserPriorityId> {
    
}
