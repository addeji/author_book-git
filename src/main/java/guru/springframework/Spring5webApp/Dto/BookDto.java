package guru.springframework.Spring5webApp.Dto;


import lombok.*;



@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String Bookname;
    private String isbn;
    private AuthorDto author;
    private CategoryDto category;
    private PublisherDto publisher;



}
