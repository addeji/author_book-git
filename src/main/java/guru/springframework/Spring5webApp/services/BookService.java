package guru.springframework.Spring5webApp.services;


import guru.springframework.Spring5webApp.domain.Book;
import guru.springframework.Spring5webApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
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
}
