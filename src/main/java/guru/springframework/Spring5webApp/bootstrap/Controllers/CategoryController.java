package guru.springframework.Spring5webApp.bootstrap.Controllers;


import guru.springframework.Spring5webApp.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/category")
    public  String getCategory(Model model){

        model.addAttribute("category",categoryRepository.findAll());

        return "category/index";
    }
}
