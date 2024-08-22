package guru.springframework.Spring5webApp.bootstrap.Controllers;


import guru.springframework.Spring5webApp.domain.Category;
import guru.springframework.Spring5webApp.repositories.CategoryRepository;
import guru.springframework.Spring5webApp.services.Impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/category-count")
    public Long getCategoryCount() {return categoryRepository.count();}

    @GetMapping("/category-names")
    public ResponseEntity<List<String>> getCategoryNames() {
        List<Category> category = (List<Category>) categoryRepository.findAll();
        List<String> categoryNames = category.stream()  //gets the names of
                // the book and puts them in a list
                .map(Category::getCategory)
                .toList();
        return ResponseEntity.ok(categoryNames);
    }
    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
