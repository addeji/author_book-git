package guru.springframework.Spring5webApp.repositories;

import guru.springframework.Spring5webApp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
