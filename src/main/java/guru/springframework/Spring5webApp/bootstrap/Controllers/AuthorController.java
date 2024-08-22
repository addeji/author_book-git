package guru.springframework.Spring5webApp.bootstrap.Controllers;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;

import guru.springframework.Spring5webApp.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;
    private static final String AUTHOR_GET = "/authors";
    private static final String AUTHOR_GET_ID = AUTHOR_GET + "/{id}";
    private static final String AUTHOR_DELETE_ID = "/delete/{id}";
    private static final String AUTHOR_ADD = AUTHOR_GET + "/add";




    @Autowired
    private AuthorService authorService;

    @GetMapping(AUTHOR_GET)
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }


    @DeleteMapping(AUTHOR_DELETE_ID)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    @PostMapping(AUTHOR_ADD)
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        Author newAuthor = authorRepository.save(author);
        return ResponseEntity.ok(newAuthor);
    }

    @PutMapping(AUTHOR_GET_ID)
    public Author editAuthorName(@PathVariable Long id, @RequestBody Author author) {
        return authorService.editAuthorName(id, author.getAuthorName());
    }




}
