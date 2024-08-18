package guru.springframework.Spring5webApp.services;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
