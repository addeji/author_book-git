package guru.springframework.Spring5webApp.Dto;

import guru.springframework.Spring5webApp.domain.Book;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class CategoryDto {

    
    private Long id;
    private String CategoryName;
    private Set<Book> books;

    public CategoryDto(Long id, String categoryName) {
        this.id = id;
        this.CategoryName = categoryName;
    }
}
