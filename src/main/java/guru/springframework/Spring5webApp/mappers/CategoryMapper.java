package guru.springframework.Spring5webApp.mappers;

import guru.springframework.Spring5webApp.Dto.CategoryDto;
import guru.springframework.Spring5webApp.domain.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    Category categoryDtoToCategory(CategoryDto categoryDto);
    CategoryDto categoryToCategoryDto(Category category);
}
