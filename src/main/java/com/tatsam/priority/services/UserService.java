package com.tatsam.priority.services;

import java.util.List;

import com.tatsam.priority.entities.User;

public interface UserService {
    public User saveUser(User user);

    public User updateUser(User user);

    public void deleteUser(User user);

    public User getUserById(Long id);

    public List<User> getAllUsers();
}
