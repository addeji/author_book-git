package guru.springframework.Spring5webApp.services;
import guru.springframework.Spring5webApp.Dto.CategoryDto;
import guru.springframework.Spring5webApp.domain.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

//    Optional<Category> getById(Long id);

    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    CategoryDto addCategory(CategoryDto categoryDTO);
    CategoryDto updateCategory(Long id, CategoryDto categoryDTO);
    void deleteCategory(Long id);
    Long getCategoryCount();

}
