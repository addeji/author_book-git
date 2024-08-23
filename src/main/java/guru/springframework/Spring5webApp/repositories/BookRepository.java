package guru.springframework.Spring5webApp.repositories;

import guru.springframework.Spring5webApp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
