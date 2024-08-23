package guru.springframework.Spring5webApp.Controllers;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;





    private final AuthorService authorService;


    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }


    @DeleteMapping("delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    @PostMapping("/add-author")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author newAuthor = authorRepository.save(author);
        return ResponseEntity.ok(newAuthor);
    }

    @PutMapping("/{id}")
    public Author editAuthorName(@PathVariable Long id, @RequestBody Author author) {
        return authorService.editAuthorName(id, author.getAuthorName());
    }




}
