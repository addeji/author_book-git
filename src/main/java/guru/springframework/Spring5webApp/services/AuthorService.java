package guru.springframework.Spring5webApp.services;

import guru.springframework.Spring5webApp.domain.Author;


import java.util.List;
import java.util.UUID;


public interface AuthorService {


     default List<Author> getAllAuthors() {return List.of();}

     default Author addAuthor(Author author) {return author;}

     default Author editAuthorName(Long authorId, String newName) {
         return null;
     }


     default void deleteAuthor(Long id) {}


}
