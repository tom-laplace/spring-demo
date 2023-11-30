package com.example.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.models.Authors;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
}
