package guru.springframework.Spring5webApp.services.Impl;

import guru.springframework.Spring5webApp.Dto.BookDto;
import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.domain.Book;

import guru.springframework.Spring5webApp.domain.Category;
import guru.springframework.Spring5webApp.repositories.AuthorRepository;
import guru.springframework.Spring5webApp.repositories.BookRepository;
import guru.springframework.Spring5webApp.services.BookService;
import guru.springframework.Spring5webApp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;
    private final AuthorRepository authorRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookNames =  bookRepository.findAll();
        log.info("get all books");
        return ResponseEntity.ok(bookNames).getBody();
    }
    @Override
    public Book addBook(Book book , Author author) {
        log.info("adding book{} adding author{}", book, author);
        Book savedBook = bookRepository.save(book);
        savedBook.setAuthor(author);
        authorRepository.save(author);
        author.getBooks().add(savedBook);
        return savedBook;

    }

    @Override
    public BookDto addCategoryToBook(BookDto book, Long categoryId) {
        log.info("adding book{} adding category{}", book, categoryId);

        Category category = categoryService.getById(categoryId).get();
        Book savedBook = new Book();
        savedBook.getCategory().add(category);
        bookRepository.save(savedBook);

        return book;
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
