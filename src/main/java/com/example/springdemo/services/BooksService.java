package com.example.springdemo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import com.example.springdemo.dto.BooksDTO;
import com.example.springdemo.models.Authors;
import com.example.springdemo.models.Books;
import com.example.springdemo.repositories.AuthorsRepository;
import com.example.springdemo.repositories.BooksRepository;

@Service
public class BooksService {

    private final BooksRepository booksRepository;
    private final AuthorsRepository authorsRepository;

    public BooksService(BooksRepository booksRepository, AuthorsRepository authorsRepository) {
        this.booksRepository = booksRepository;
        this.authorsRepository = authorsRepository;
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

    public Books addBook(BooksDTO bookDTO) {
        Books book = new Books();
        book.setTitle(bookDTO.getTitle());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(bookDTO.getPublicationDate(), formatter);
        book.setPublicationDate(date);

        Authors author = authorsRepository.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Auteur non trouvé avec id : " + bookDTO.getAuthorId()));
        book.setAuthor(author);

        book.setNumberOfCopies(bookDTO.getNumberOfCopies());

        return booksRepository.save(book);
    }

    public Books updateBook(Long id, Books bookDetails) {
        Books book = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livre non trouvé avec id : " + id));

        if (!ObjectUtils.isEmpty(bookDetails.getTitle())) {
            book.setTitle(bookDetails.getTitle());
        }

        if (!ObjectUtils.isEmpty(bookDetails.getAuthor())) {
            book.setAuthor(bookDetails.getAuthor());
        }

        if (!ObjectUtils.isEmpty(bookDetails.getPublicationDate())) {
            book.setPublicationDate(bookDetails.getPublicationDate());
        }

        if (!ObjectUtils.isEmpty(bookDetails.getNumberOfCopies())) {
            book.setNumberOfCopies(bookDetails.getNumberOfCopies());
        }

        return booksRepository.save(book);
    }

    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }
}