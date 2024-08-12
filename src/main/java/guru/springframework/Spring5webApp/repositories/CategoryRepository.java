package guru.springframework.Spring5webApp.repositories;

import guru.springframework.Spring5webApp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
