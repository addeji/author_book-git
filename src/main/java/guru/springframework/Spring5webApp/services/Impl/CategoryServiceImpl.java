package guru.springframework.Spring5webApp.services.Impl;


import guru.springframework.Spring5webApp.domain.Category;
import guru.springframework.Spring5webApp.repositories.CategoryRepository;
import guru.springframework.Spring5webApp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        log.info("getAllCategories");
        return  categoryRepository.findAll();
    }
    @Override
    public Category addCategory(Category category) {
        log.info("addedCategory{}", category);
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getById(Long id) {
        log.info("getById {}", id);
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteCategory(Long id) {
        log.info("deletedCategory{}", id);
        categoryRepository.deleteById(id);
    }
    @Override
    public Long getCategoryCount() {
        return categoryRepository.count();
    }
}
