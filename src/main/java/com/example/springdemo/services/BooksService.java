package com.example.springdemo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.springdemo.models.Books;
import com.example.springdemo.repositories.BooksRepository;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> findAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Books> findBookById(Long id) {
        return booksRepository.findById(id);
    }

    public List<Books> findBooksByTitle(String title) {
        return booksRepository.findByTitle(title);
    }

    public Books addBook(Books book) {
        if (!(book instanceof Books)) {
            throw new RuntimeException("L'objet n'est pas de type Books");
        }

        return booksRepository.save(book);
    }

    public Books updateBook(Long id, Books bookDetails) {
        Books book = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livre non trouvé avec id : " + id));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublicationDate(bookDetails.getPublicationDate());
        book.setNumberOfCopies(bookDetails.getNumberOfCopies());

        return booksRepository.save(book);
    }

    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }
}