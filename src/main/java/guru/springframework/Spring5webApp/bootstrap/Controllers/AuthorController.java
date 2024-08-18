package guru.springframework.Spring5webApp.bootstrap.Controllers;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.repositories.BookRepository;
import guru.springframework.Spring5webApp.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;




    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }


    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    @PostMapping("/add-author")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author newAuthor = authorRepository.save(author);
        return ResponseEntity.ok(newAuthor);
    }




}
