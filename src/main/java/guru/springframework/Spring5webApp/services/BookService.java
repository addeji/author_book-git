package guru.springframework.Spring5webApp.services;

import guru.springframework.Spring5webApp.Dto.BookDto;
import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.domain.Book;


import java.util.List;

public interface BookService {

     List<Book> getAllBooks();

    Book addBook(Book book , Author author);

    Book GetBookById(Long id);

   void deleteBook(Long id) ;

    Book editBookName(Long bookId, String newName) ;
    public BookDto addCategoryToBook(BookDto bookDto, Long categoryId);
}
