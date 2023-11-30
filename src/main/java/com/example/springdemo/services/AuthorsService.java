package com.example.springdemo.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.springdemo.models.Authors;
import com.example.springdemo.repositories.AuthorsRepository;

@Service
public class AuthorsService {

    private final AuthorsRepository authorsRepository;

    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public List<Authors> findAllAuthors() {
        return authorsRepository.findAll();
    }

    public Optional<Authors> findAuthorById(Long id) {
        return authorsRepository.findById(id);
    }

    public Authors addAuthor(Authors author) {
        if (!(author instanceof Authors)) {
            throw new RuntimeException("L'objet n'est pas de type Authors");
        }

        return authorsRepository.save(author);
    }

    public Authors updateAuthor(Long id, Authors authorDetails) {
        Authors author = authorsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auteur non trouvé avec id : " + id));

        if (authorDetails.getFirstName() != null) {
            author.setFirstName(authorDetails.getFirstName());
        }

        if (authorDetails.getLastName() != null) {
            author.setLastName(authorDetails.getLastName());
        }

        return authorsRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorsRepository.deleteById(id);
    }

}
