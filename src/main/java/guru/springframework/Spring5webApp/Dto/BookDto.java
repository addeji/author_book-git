package guru.springframework.Spring5webApp.Dto;

import guru.springframework.Spring5webApp.domain.Author;
import guru.springframework.Spring5webApp.domain.Category;
import guru.springframework.Spring5webApp.domain.Publisher;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class BookDto {

    private Long id;
    private String Bookname;
    private String isbn;
    private Publisher publisher;
    private Author author ;
    private Set<Category> category= new HashSet<>();




    public BookDto(Long id, String bookname, String isbn) {
        this.id = id;
        Bookname = bookname;
        this.isbn = isbn;
    }
}
