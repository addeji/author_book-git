package guru.springframework.Spring5webApp.services;

import guru.springframework.Spring5webApp.domain.Category;

import java.util.List;

public interface CategoryService {
    public default List<Category> getAllCategories() {

        return List.of();
    }

    public default Category addCategory(Category category) {

        return category;
    }

    public default void deleteCategory(Long id) {

    }
}
