package com.example.springdemo.services.authors;

import com.example.springdemo.models.Authors;

import java.util.List;
import java.util.Optional;

public interface IAuthorsService {
    List<Authors> findAllAuthors();

    Optional<Authors> findAuthorById(Long id);

    Authors addAuthor(Authors author);

    Authors updateAuthor(Long id, Authors authorDetails);

    void deleteAuthor(Long id);
}
