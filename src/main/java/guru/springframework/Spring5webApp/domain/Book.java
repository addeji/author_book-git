package guru.springframework.Spring5webApp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "book")
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String Bookname;

    private String isbn;

    @ManyToOne
    private Publisher publisher;

    @ManyToOne
    private Author author ;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Category category;


    public Book(String bookOfIce, String number) {
        this.Bookname = bookOfIce;
        this.isbn = number;
    }
}
