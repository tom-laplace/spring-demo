package com.example.springdemo.services.books;

import com.example.springdemo.dto.BooksDTO;
import com.example.springdemo.models.Books;

import java.util.List;
import java.util.Optional;

public interface IBooksService {
    List<Books> findAllBooks();

    Optional<Books> findBookById(Long id);

    List<Books> findBooksByTitle(String title);

    Books addBook(BooksDTO bookDTO);

    Books updateBook(Long id, Books bookDetails);

    void deleteBook(Long id);
}
