package guru.springframework.Spring5webApp.repositories;

import guru.springframework.Spring5webApp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
