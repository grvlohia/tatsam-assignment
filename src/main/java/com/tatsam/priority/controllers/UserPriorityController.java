package com.tatsam.priority.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tatsam.priority.entities.Priority;
import com.tatsam.priority.entities.UserPriority;
import com.tatsam.priority.services.PriorityService;
import com.tatsam.priority.services.UserPriorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserPriorityController {
    @Autowired
    UserPriorityService userPriorityService;

    @Autowired
    PriorityService priorityService;

    /*
    This path consumes application/json data.
    And assumes that the request body will contain the priority order and the satisfaction rating 
    in the following format
    {
        "connection": {
            "priority": 3,
            "satisfaction": 5
        },
        "relationships": {
            "priority": 2,
            "satisfaction": 3
        },
        "career": {
            "priority": 1,
            "satisfaction": 5
        },
        "wealth": {
            "priority": 4,
            "satisfaction": 5
        }
    }

    And also if there is repeated value for "priority" field then a HttpStatus.BAD_REQUEST is returned.
     */
    @PostMapping(path = "/users/{userId}/priorities", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> saveUserPriorities(@PathVariable Long userId, @RequestBody Map<String, Map<String, String>> body) {
        List<Priority> priorityCategories = priorityService.getAllPriorities();
        
        // Check for unique priority value for each category
        List<Integer> values = new ArrayList<>();
        for(Map.Entry<String, Map<String, String>> entry : body.entrySet()) {
            int pOrder = Integer.parseInt(entry.getValue().get("priority"));
            if (values.contains(pOrder))
            return new ResponseEntity<>("Priority Order contains repeated values", HttpStatus.BAD_REQUEST);
            else
            values.add(pOrder);
        }
        
        // Get id number of priority category from the database and create a HashMap with corresponding names.
        Map<String, Long> categoryNameMapping = new HashMap<>();
        for (Priority category: priorityCategories) {
            categoryNameMapping.put(category.getCategory().toLowerCase(), category.getId());
        }
        
        // Saving priority order for each category.
        for(Map.Entry<String, Map<String, String>> entry : body.entrySet()) {
            UserPriority userPriority = new UserPriority();
            userPriority.setUserId(userId);
            userPriority.setPriorityId(categoryNameMapping.get(entry.getKey()));
            userPriority.setPriorityOrder(Integer.parseInt(entry.getValue().get("priority")));
            userPriority.setSatisfactionRating(Integer.parseInt(entry.getValue().get("satisfaction")));

            userPriorityService.saveUserPriority(userPriority);
        }
        return new ResponseEntity<>("Data Saved", HttpStatus.OK);
    }
}
