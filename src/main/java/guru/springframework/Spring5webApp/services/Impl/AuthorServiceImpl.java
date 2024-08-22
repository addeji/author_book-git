package guru.springframework.Spring5webApp.services.Impl;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author editAuthorName(Long authorId, String newName) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        author.setAuthorName(newName);
        return authorRepository.save(author);
    }




    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }



}
