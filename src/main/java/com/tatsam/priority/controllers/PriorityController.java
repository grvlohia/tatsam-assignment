package com.tatsam.priority.controllers;

import java.util.List;

import com.tatsam.priority.entities.Priority;
import com.tatsam.priority.services.PriorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriorityController {

    @Autowired
    PriorityService priorityService;
    
    @GetMapping(path = "/priorities", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Priority> allPriorities() {
        return priorityService.getAllPriorities();
    }
}
