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
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String PublisherName;
    private String addressline;
    private String city;
    private String zip;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();


    public Publisher(String publisherName) {
        this.PublisherName = publisherName;
    }


    public Publisher(String publisherName, String addressline, String zip, String city) {
        this.PublisherName = publisherName;
        this.addressline = addressline;
        this.zip = zip;
        this.city = city;

    }
}