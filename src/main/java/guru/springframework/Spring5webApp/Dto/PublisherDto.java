package guru.springframework.Spring5webApp.Dto;

import guru.springframework.Spring5webApp.domain.Book;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDto {

    private Long id;
    private String PublisherName;
    private String addressline;
    private String city;
    private String zip;
    private Set<Book> books;

    public PublisherDto( Long id,  String publisherName) {
        this.id = id;
        PublisherName = publisherName;
    }



}
