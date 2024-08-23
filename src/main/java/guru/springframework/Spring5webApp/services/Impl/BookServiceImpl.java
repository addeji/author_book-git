package guru.springframework.Spring5webApp.services.Impl;


import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.repositories.BookRepository;
import guru.springframework.Spring5webApp.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> bookNames =  bookRepository.findAll();
        log.info("get all books");
        return ResponseEntity.ok(bookNames).getBody();
    }

    public Book addBook(Book book) {
        log.info("add book" + book);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        log.info("delete book" + id);
        bookRepository.deleteById(id);
    }
    public Book editBookName(Long bookId, String newName) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        book.setBookname(newName);
        log.info("book edited" + book);
        return bookRepository.save(book);
    }
}
