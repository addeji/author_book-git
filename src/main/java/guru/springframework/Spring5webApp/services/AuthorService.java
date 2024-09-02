package guru.springframework.Spring5webApp.services;

import guru.springframework.Spring5webApp.Dto.AuthorDto;
import guru.springframework.Spring5webApp.Dto.BookDto;



import java.util.List;



public interface AuthorService {


      List<AuthorDto> getAllAuthors() ;
      AuthorDto addAuthor(AuthorDto authordto) ;
    AuthorDto getAuthorById(Long id);
    AuthorDto editAuthorName(Long authorId, AuthorDto authorDto);
    void deleteAuthor(Long id) ;


}
