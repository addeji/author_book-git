package guru.springframework.Spring5webApp.services;

import guru.springframework.Spring5webApp.Dto.BookDto;



import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();
    BookDto getBookById(Long id);
    BookDto addBook(BookDto bookDTO);
    BookDto editBook(Long id, BookDto bookDTO);
    void deleteBook(Long id);
}
