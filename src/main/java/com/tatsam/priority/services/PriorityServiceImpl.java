package com.tatsam.priority.services;

import java.util.List;
import java.util.Optional;

import com.tatsam.priority.entities.Priority;
import com.tatsam.priority.repositories.PriorityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriorityServiceImpl implements PriorityService{
    
    @Autowired
    private PriorityRepository priorityRepository;

    public Priority savePriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    public Priority updatePriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    public void deletePriority(Priority priority) {
        priorityRepository.delete(priority); 
    }

    public Priority getPriorityById(Long id) {
        Optional<Priority> foundPriority = priorityRepository.findById(id);
        if (foundPriority.isPresent())
            return foundPriority.get();
        return null;
    }

    public List<Priority> getAllPriorities() {
        return priorityRepository.findAll();
    }
}
