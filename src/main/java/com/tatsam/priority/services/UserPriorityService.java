package com.tatsam.priority.services;

import java.util.List;

import com.tatsam.priority.entities.UserPriority;
import com.tatsam.priority.entities.UserPriorityId;

public interface UserPriorityService {
    public UserPriority saveUserPriority(UserPriority userPriority);

    public UserPriority updateUserPriority(UserPriority userPriority);

    public void deleteUserPriority(UserPriority userPriority);

    public UserPriority getUserPriorityById(UserPriorityId id);

    public List<UserPriority> getAllUserPriority();

    public List<UserPriority> saveAllUserPriorities(List<UserPriority> allPriorities);
}
