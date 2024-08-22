package guru.springframework.Spring5webApp.services;

import guru.springframework.Spring5webApp.domain.Book;


import java.util.List;

public interface BookService {

    default List<Book> getAllBooks() {

        return List.of();
    }

   default Book addBook(Book book) {

        return book;
    }

  default void deleteBook(Long id) {

    }
     default Book editBookName(Long bookId, String newName) {

        return null;
    }
}
