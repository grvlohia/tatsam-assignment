package com.tatsam.priority.services;

import java.util.List;

import com.tatsam.priority.entities.Priority;

public interface PriorityService {

    public Priority savePriority(Priority priority);

    public Priority updatePriority(Priority priority);

    public void deletePriority(Priority priority);

    public Priority getPriorityById(Long id);

    public List<Priority> getAllPriorities();
}
