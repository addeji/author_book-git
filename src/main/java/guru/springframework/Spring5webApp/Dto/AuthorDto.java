package guru.springframework.Spring5webApp.Dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import guru.springframework.Spring5webApp.domain.Book;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AuthorDto {
    private Long id;
    private String AuthorName;
    private List<Book> books = new ArrayList<>();




}
