package com.tatsam.priority.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.tatsam.priority.entities.User;
import com.tatsam.priority.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/users")
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{userId}")
    public User findUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(path = "/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping(path = "/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User foundUser = userService.getUserById(userId);
        if (foundUser == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        foundUser.setUsername(updatedUser.getUsername());
        foundUser.setPhone(updatedUser.getPhone());
        foundUser.setEmail(updatedUser.getEmail());
        return new ResponseEntity<>(userService.updateUser(foundUser), HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user == null)
            return new ResponseEntity<>(String.format("No user found with id: %d", userId), HttpStatus.BAD_REQUEST);
        userService.deleteUser(user);
        return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }

}
