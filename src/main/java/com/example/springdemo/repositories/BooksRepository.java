package com.example.springdemo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.models.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

    Books findById(long idBooks);

    Books findByTitle(String title);

    List<Books> getAllByAuthorList(String author);

    List<Books> getAllByPublicationDateList(String publicationDate);

    List<Books> getAllByAuthorOrTitleList(String author, String title);
}
