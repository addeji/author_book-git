package guru.springframework.Spring5webApp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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
    private Publisher publisher;

    @ManyToOne
    @JoinTable(name = "author_book", joinColumns =
    @JoinColumn(name = "book_id"), inverseJoinColumns =
    @JoinColumn(name = "author_id"))
    private Author author ;
    @ManyToMany
    @JoinTable(name = "book_category",joinColumns = @JoinColumn(name = "book_id" )
            ,inverseJoinColumns = @JoinColumn(name = "category"))
    private Set<Category> category= new HashSet<>();


    public Book(String bookname, String isbn) {
        this.Bookname = bookname;
        this.isbn = isbn;

    }


}
