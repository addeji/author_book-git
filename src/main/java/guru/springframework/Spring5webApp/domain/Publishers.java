package guru.springframework.Spring5webApp.domain;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity

public class Publishers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String PublisherName;
    private String addressline1;
    private String city;
    private String zip;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();




    public Publishers() {
    }


    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public Set<Book> getBooks() {
        return books;
    }



    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public void setPublisherName(String publisherName) {
        PublisherName = publisherName;
    }



    @Override
    public String toString() {
        return "Publishers{" +
                "id=" + id +
                ", PublisherName='" + PublisherName + '\'' +
                ", addressline1='" + addressline1 + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publishers publishers = (Publishers) o;
        return id!=null ? id.equals(publishers.id) : publishers.id== null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
