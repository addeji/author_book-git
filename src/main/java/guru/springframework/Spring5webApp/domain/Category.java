package guru.springframework.Spring5webApp.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;
    private String Category;
    @OneToMany(mappedBy = "category")
    private Set<Book> books = new HashSet<>();





    public Category(String Category) {
        this.Category = Category;
    }

}
