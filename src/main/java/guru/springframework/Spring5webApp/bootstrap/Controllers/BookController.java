package guru.springframework.Spring5webApp.bootstrap.Controllers;

import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.repositories.BookRepository;
import guru.springframework.Spring5webApp.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @GetMapping("/get-books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();


    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }



//    @GetMapping("/index")
//        public  String getBooksTemplate(Model model){
//
//        model.addAttribute("book",bookRepository.findAll());
//
//        return bookRepository.findAll().toString();
//    }
//
    @GetMapping("/book-count")
    public Long getBookCount() {return bookRepository.count();}
//
//    @GetMapping("/book-names")
//    public ResponseEntity<List<String>> getBookNames() {
//        List<Book> books = (List<Book>) bookRepository.findAll();
//        List<String> bookNames = books.stream()  //gets the names of
//                // the book and puts them in a list
//                .map(Book::getBookname)
//                .toList();
//        return ResponseEntity.ok(bookNames);
//    }
//
//
//    @PostMapping("/add-book")
//    public ResponseEntity<Book> addBook(@RequestBody Book book) {
//        Book newBook = bookRepository.save(book);
//        return ResponseEntity.ok(newBook);
//    }
//    @DeleteMapping("/delete-book/{bookId}")
//    public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
//        bookRepository.deleteById(bookId);
//        return ResponseEntity.ok("Book deleted successfully");
//    }
//    @PutMapping("/update-book/{bookId}")
//    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book updatedBook) {
//        Book book = bookRepository.findById(bookId).orElseThrow();
//        book.setBookname(updatedBook.getBookname());
//        book.setAuthors(updatedBook.getAuthors());
//        // Update other book fields as needed
//        Book updatedBookEntity = bookRepository.save(book);
//        return ResponseEntity.ok(updatedBookEntity);
//    }

}
