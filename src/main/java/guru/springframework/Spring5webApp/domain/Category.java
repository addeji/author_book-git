package guru.springframework.Spring5webApp.domain;


import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String CategoryName;
    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();


    public Category(String categoryName) {
        this.CategoryName = categoryName;
    }
}
