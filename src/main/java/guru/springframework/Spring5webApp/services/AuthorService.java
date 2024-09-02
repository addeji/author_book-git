package guru.springframework.Spring5webApp.services;

import guru.springframework.Spring5webApp.Dto.BookDto;
import guru.springframework.Spring5webApp.domain.Author;


import java.util.List;



public interface AuthorService {


      List<Author> getAllAuthors() ;

      Author addAuthor(Author author) ;

    Author getAuthorById(Long id);

    Author editAuthorName(Long authorId, String newName);

    Author addAuthortoBook(Long authorId, BookDto bookdto);


      void deleteAuthor(Long id) ;


}
