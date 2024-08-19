package guru.springframework.Spring5webApp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;
    private String Bookname;
    private String isbn;
    @ManyToOne
    private Publishers publishers;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns =
    @JoinColumn(name = "book_id"), inverseJoinColumns =
    @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "category_book",joinColumns = @JoinColumn(name = "book_id" )
            ,inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> category;


//
    public Book(String bookname, String isbn) {
        Bookname = bookname;
        this.isbn = isbn;

    }


}
