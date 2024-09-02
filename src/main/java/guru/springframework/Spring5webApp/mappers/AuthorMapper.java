package guru.springframework.Spring5webApp.mappers;

import guru.springframework.Spring5webApp.Dto.AuthorDto;
import guru.springframework.Spring5webApp.domain.Author;
import org.mapstruct.Mapper;


@Mapper
public interface AuthorMapper {

    Author AuthorDtoToAuthor(AuthorDto authorDto);


    AuthorDto AuthorToAuthorDto(Author author);

}
