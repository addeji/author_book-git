package guru.springframework.Spring5webApp.services.Impl;


import guru.springframework.Spring5webApp.domain.Category;
import guru.springframework.Spring5webApp.repositories.CategoryRepository;
import guru.springframework.Spring5webApp.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        log.info("getAllCategories");
        return  categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        log.info("addCategory" + category);
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        log.info("deleteCategory" + id);
        categoryRepository.deleteById(id);
    }
}
