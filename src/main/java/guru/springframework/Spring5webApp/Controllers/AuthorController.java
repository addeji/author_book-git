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
    public List<AuthorDto> getAllAuthors() {

        return authorService.getAllAuthors();
    }


    @DeleteMapping("delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    @PostMapping("/add-author")
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDTO) {
        return authorService.addAuthor(authorDTO);
    }

    @PutMapping("/{id}")
    public AuthorDto editAuthorName(@PathVariable Long id, AuthorDto authorDto) {
            return authorService.editAuthorName(id, authorDto);

    }



//    @GetMapping("/authors-ID/{id}")
//    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
//        AuthorDto author = authorService.getAuthorById(id);
//        if (author == null) {return ResponseEntity.notFound().build();}
//
//        AuthorDto authorDto = new AuthorDto(author.getId(), author.getAuthorName());
//        authorDto.setBooks(author.getBooks());
//
//        return ResponseEntity.ok(authorDto);
//    }


}
