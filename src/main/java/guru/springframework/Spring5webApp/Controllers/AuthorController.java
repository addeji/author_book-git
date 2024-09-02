package guru.springframework.Spring5webApp.Controllers;

import guru.springframework.Spring5webApp.Dto.AuthorDto;
import guru.springframework.Spring5webApp.Dto.BookDto;
import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authors")
public class AuthorController {






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
        Author newAuthor = authorService.addAuthor(author);
        return ResponseEntity.ok(newAuthor);
    }

    @PutMapping("/{id}")
    public Author editAuthorName(@PathVariable Long id, Author author) {
        return authorService.editAuthorName(id, author.getAuthorName());
    }

    @GetMapping("/authors-ID/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {return ResponseEntity.notFound().build();}

        AuthorDto authorDto = new AuthorDto(author.getId(), author.getAuthorName());
        authorDto.setBooks(author.getBooks());

        return ResponseEntity.ok(authorDto);
    }
    @PostMapping("/add-author-to-book")
    public ResponseEntity<Author> addAuthorToBook(@RequestBody BookDto bookDto , Long Id) {
        Author author =  authorService.addAuthortoBook(Id , bookDto);
        if (author == null) {return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(author);


    }


}
