package com.example.springdemo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.models.Users;
import com.example.springdemo.services.users.UsersServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersServiceImpl usersService;

    public UsersController(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable Long id) {
        Users users = usersService.getUsersById(id);
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<Users> addUsers(@RequestBody Users users) {
        Users savedUsers = usersService.addUsers(users);
        return ResponseEntity.ok(savedUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
        usersService.deleteUsers(id);
        return ResponseEntity.ok().build();
    }
}
