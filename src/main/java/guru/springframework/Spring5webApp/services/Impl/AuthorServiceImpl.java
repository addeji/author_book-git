package guru.springframework.Spring5webApp.services.Impl;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        log.info("getAllAuthors");
        return authorRepository.findAll();
    }

    public Author addAuthor(Author author) {
        log.info("Adding author: " + author);
        return authorRepository.save(author);
    }

    public Author editAuthorName(Long authorId, String newName) {
        Author author = authorRepository.findById(authorId).orElseThrow();
        author.setAuthorName(newName);
        log.info("Author updated" + author);
        return authorRepository.save(author);
    }




    public void deleteAuthor(Long id) {
        log.info("Deleting author: " + id);
        authorRepository.deleteById(id);
    }



}
