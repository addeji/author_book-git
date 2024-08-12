package guru.springframework.Spring5webApp.domain;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Category;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();




    public Category() {
    }
    public Category(String Category) {
        this.Category = Category;
    }



    public Set<Book> getBooks() {
        return books;
    }




    public String Category() {
        return Category;
    }

    public void Category(String category) {
        Category = category;
    }



    @Override
    public String toString() {
        return "Publishers{" +
                "id=" + id +
                ", PublisherName='" + Category + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category publishers = (Category) o;
        return id!=null ? id.equals(publishers.id) : publishers.id== null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
