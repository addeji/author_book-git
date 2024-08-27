package guru.springframework.Spring5webApp.services.Impl;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.domain.Book;

import guru.springframework.Spring5webApp.repositories.BookRepository;
import guru.springframework.Spring5webApp.services.BookService;
import guru.springframework.Spring5webApp.services.PublisherService;
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
    private PublisherService publisherService;

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookNames =  bookRepository.findAll();
        log.info("get all books");
        return ResponseEntity.ok(bookNames).getBody();
    }
    @Override
    public Book addBook(Book book , Author author) {
        log.info("add book{}author{}", book, author);

        Book savedBook = bookRepository.save(book);
        savedBook.setAuthor(author);
        author.getBooks().add(savedBook);
        return savedBook;

    }

    @Override
    public Book GetBookById(Long id) {
        return bookRepository.findById(id).orElse(null);

    }

    @Override
    public void deleteBook(Long id) {
        log.info("delete book{}", id);
        bookRepository.deleteById(id);
    }
    @Override
    public Book editBookName(Long bookId, String newName) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        book.setBookname(newName);
        log.info("book edited{}", book);
        return bookRepository.save(book);
    }
}
