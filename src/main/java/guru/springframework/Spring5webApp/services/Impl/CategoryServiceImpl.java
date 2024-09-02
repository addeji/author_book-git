package guru.springframework.Spring5webApp.services.Impl;


import guru.springframework.Spring5webApp.Dto.CategoryDto;
import guru.springframework.Spring5webApp.domain.Category;
import guru.springframework.Spring5webApp.mappers.BookMapper;
import guru.springframework.Spring5webApp.mappers.CategoryMapper;
import guru.springframework.Spring5webApp.repositories.CategoryRepository;
import guru.springframework.Spring5webApp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    private  CategoryMapper categoryMapper;



    @Override
    public List<CategoryDto> getAllCategories() {
        log.info("getAllAuthors");
        List<Category> category = categoryRepository.findAll();
        return category.stream()
                .map(categoryMapper::categoryToCategoryDto)
                .collect(Collectors.toList());
    }
    @Override
    public CategoryDto addCategory(CategoryDto dto) {
        log.info("Add Category{}", dto);
        Category category = categoryMapper.categoryDtoToCategory(dto);
        categoryRepository.save(category);
        return categoryMapper.categoryToCategoryDto(category);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        log.info("getCategoryById");
         Category category = categoryRepository.findById(id).orElseThrow();
        return categoryMapper.categoryToCategoryDto(category);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto dto ) {
        log.info("Edit Category Name: {}", id);
        Category category = categoryRepository.findById(id).orElseThrow();
        category.setCategoryName(dto.getCategoryName());
        category.setBooks(dto.getBooks());
        categoryRepository.save(category);
        return categoryMapper.categoryToCategoryDto(category);
    }

    @Override
    public void deleteCategory(Long id) {
        log.info("deletedCategory{}", id);
        categoryRepository.deleteById(id);
    }
    @Override
    public Long getCategoryCount() {
        log.info("gettingCategoryCount");
        return categoryRepository.count();
    }
}
