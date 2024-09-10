package guru.springframework.Spring5webApp.Dto;

import guru.springframework.Spring5webApp.domain.Book;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class AuthorDto {
    private Long id;
    private String AuthorName;
    private List<Book> books;

    public AuthorDto(Long id, String authorName) {
        this.id = id;
        this.AuthorName = authorName;
    }
}
