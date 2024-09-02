package guru.springframework.Spring5webApp.Controllers;

import guru.springframework.Spring5webApp.Dto.BookDto;
import guru.springframework.Spring5webApp.repositories.BookRepository;
import guru.springframework.Spring5webApp.services.BookService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    private final BookService bookService;


    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        BookDto book = bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        }

       return ResponseEntity.ok(book);
    }

    @PostMapping
    public BookDto addBook(@RequestBody BookDto bookDto) {

        return bookService.addBook(bookDto);

    }

//    @PostMapping("/categoryId/{categoryId}")
//    public ResponseEntity<BookDto> addCategoryToBook(@RequestBody BookDto bookDto,
//              @PathVariable("categoryId")Long categoryId ) {
//       return new
//               ResponseEntity<BookDto>(bookService.addCategoryToBook(bookDto, categoryId)
//               ,HttpStatusCode.valueOf(200));
//    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }


    @GetMapping("/count")
    public Long getBookCount() {return bookRepository.count();}

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody BookDto bookDTO) {
        return bookService.editBook(id, bookDTO);
    }


}

