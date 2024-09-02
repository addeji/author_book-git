package guru.springframework.Spring5webApp.mappers;

import guru.springframework.Spring5webApp.Dto.BookDto;
import guru.springframework.Spring5webApp.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {

    Book boookDtoToBook(BookDto bookDto);
    BookDto booktobookDto(Book book);
}
