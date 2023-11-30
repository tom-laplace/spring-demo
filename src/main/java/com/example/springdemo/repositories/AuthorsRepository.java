package com.example.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.models.Authors;
import java.util.List;


public interface AuthorsRepository extends JpaRepository<Authors, Long> {

    Authors findById(long id);

    List<Authors> findByFirstNameAndLastName(String firstName, String lastName);

    List<Authors> findByFirstNameOrLastName(String firstName, String lastName);
}
