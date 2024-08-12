package guru.springframework.Spring5webApp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity(name = "book")
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Bookname;
    private String isbn;
    @ManyToOne
    private Publishers publishers;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories ;



    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public Category getCategories() {
        return categories;
    }

    @ManyToMany
    @JoinTable(name = "author_book" , joinColumns = @JoinColumn(name = "book_id")
            , inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();


    public Book() {
    }

    public Book(String bookname, String isbn) {
        Bookname = bookname;
        this.isbn = isbn;

    }


    public void setPublishers(Publishers publishers) {
        this.publishers = publishers;
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Bookname='" + Bookname + '\'' +
                ", isbn='" + isbn + '\'' +'}';
    }


    public Set<Author> getAuthors() {
        return authors;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    

}
