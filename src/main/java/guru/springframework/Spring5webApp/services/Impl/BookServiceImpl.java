package guru.springframework.Spring5webApp.services.Impl;


import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.repositories.BookRepository;
import guru.springframework.Spring5webApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> bookNames = (List<Book>) bookRepository.findAll();
        return ResponseEntity.ok(bookNames).getBody();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public Book editBookName(Long bookId, String newName) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        book.setBookname(newName);
        return bookRepository.save(book);
    }
}
