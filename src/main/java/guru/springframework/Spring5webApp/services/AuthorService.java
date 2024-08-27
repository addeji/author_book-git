package guru.springframework.Spring5webApp.services;

import guru.springframework.Spring5webApp.domain.Author;


import java.util.List;



public interface AuthorService {


      List<Author> getAllAuthors() ;

      Author addAuthor(Author author) ;

    Author getAuthorById(Long id);

    Author editAuthorName(Long authorId, String newName);


      void deleteAuthor(Long id) ;


}
