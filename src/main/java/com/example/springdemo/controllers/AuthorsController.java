package com.example.springdemo.controllers;

import java.util.Optional;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.models.Authors;
import com.example.springdemo.services.authors.AuthorsServiceImpl;

@RestController
@RequestMapping("/api/authors")
public class AuthorsController {

    private final AuthorsServiceImpl authorsService;

    public AuthorsController(AuthorsServiceImpl authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping
    public ResponseEntity<List<Authors>> getAllAuthors() {
        return ResponseEntity.ok(authorsService.findAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Authors> getAuthorById(@PathVariable Long id) {
        Optional<Authors> author = authorsService.findAuthorById(id);
        return author.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Authors> addAuthor(@RequestBody Authors author) {
        Authors savedAuthor = authorsService.addAuthor(author);
        return ResponseEntity.ok(savedAuthor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Authors> updateAuthor(@PathVariable Long id, @RequestBody Authors authorDetails) {
        Authors updatedAuthor = authorsService.updateAuthor(id, authorDetails);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorsService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }
}