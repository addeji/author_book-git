package guru.springframework.Spring5webApp.services;

import guru.springframework.Spring5webApp.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories() ;
     Category addCategory(Category category);

    void deleteCategory(Long id) ;
}
