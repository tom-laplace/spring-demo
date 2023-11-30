package com.example.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findById(long id);

    Users findByUsername(String username);
    
}