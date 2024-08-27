package guru.springframework.Spring5webApp.Controllers;

import guru.springframework.Spring5webApp.Dto.BookDto;
import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.domain.Book;
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
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();


    }
    @GetMapping("/books/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        Book book = bookService.GetBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        BookDto bookDto = new BookDto(book.getId(), book.getBookname(), book.getIsbn());
        bookDto.setAuthor(book.getAuthor());

        return ResponseEntity.ok(bookDto);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book , Author author) {

        return bookService.addBook(book ,author);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }




    @GetMapping("/book-count")
    public Long getBookCount() {return bookRepository.count();}

    @PutMapping("edit/{id}")
    public Book editBookName(@PathVariable Long id, @RequestBody  Book book) {
        return bookService.editBookName(id, book.getBookname());
    }



    }

