package guru.springframework.Spring5webApp.bootstrap.Controllers;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.domain.Publishers;
import guru.springframework.Spring5webApp.repositories.BookRepository;
import guru.springframework.Spring5webApp.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();


    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
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
