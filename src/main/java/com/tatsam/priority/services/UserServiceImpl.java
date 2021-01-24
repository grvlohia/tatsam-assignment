package com.tatsam.priority.services;

import java.util.List;
import java.util.Optional;

import com.tatsam.priority.entities.User;
import com.tatsam.priority.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User getUserById(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent())
            return foundUser.get();
        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
