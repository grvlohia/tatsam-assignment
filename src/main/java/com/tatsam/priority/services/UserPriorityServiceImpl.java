package com.tatsam.priority.services;

import java.util.List;
import java.util.Optional;

import com.tatsam.priority.entities.UserPriority;
import com.tatsam.priority.entities.UserPriorityId;
import com.tatsam.priority.repositories.UserPriorityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPriorityServiceImpl implements UserPriorityService {

    @Autowired
    UserPriorityRepository userPriorityRepository;

    public UserPriority saveUserPriority(UserPriority userPriority) {
        return userPriorityRepository.save(userPriority);
    }

    public UserPriority updateUserPriority(UserPriority userPriority) {
        return userPriorityRepository.save(userPriority);
    }

    public void deleteUserPriority(UserPriority userPriority) {
        userPriorityRepository.delete(userPriority);
    }

    public UserPriority getUserPriorityById(UserPriorityId id) {
        Optional<UserPriority> foundUserPriority = userPriorityRepository.findById(id);
        if (foundUserPriority.isPresent())
            return foundUserPriority.get();
        return null;
    }

    public List<UserPriority> getAllUserPriority() {
        return userPriorityRepository.findAll();
    }

    public List<UserPriority> saveAllUserPriorities(List<UserPriority> allPriorities) {
        return userPriorityRepository.saveAll(allPriorities);
    }
}
