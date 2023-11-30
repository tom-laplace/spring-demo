package com.example.springdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.models.Books;
import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {

    List<Books> findByTitle(String title);
}
