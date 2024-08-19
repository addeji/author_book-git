package guru.springframework.Spring5webApp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;
    private String AuthorName;
    @ManyToMany(mappedBy = "authors",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();




    }



