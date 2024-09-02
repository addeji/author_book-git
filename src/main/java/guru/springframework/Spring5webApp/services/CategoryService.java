package guru.springframework.Spring5webApp.services;
import guru.springframework.Spring5webApp.domain.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories() ;
     Category addCategory(Category category);
    Optional<Category> getById(Long id);
    void deleteCategory(Long id) ;
    Long getCategoryCount();
}
