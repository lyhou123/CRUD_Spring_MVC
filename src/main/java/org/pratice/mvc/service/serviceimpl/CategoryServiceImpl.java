package org.pratice.mvc.service.serviceimpl;
import lombok.RequiredArgsConstructor;
import org.pratice.mvc.dto.CategoryRequest;
import org.pratice.mvc.dto.CategoryRespone;
import org.pratice.mvc.model.Category;
import org.pratice.mvc.repository.CategoryProductRepository;
import org.pratice.mvc.service.CategoryService;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService
{
    private final CategoryProductRepository categoryProductRepository;
    private CategoryRespone MapCategoryResopne(Category category)
    {
       return CategoryRespone.builder()
               .id(category.getId())
               .description(category.getDescription())
               .title(category.getTitle())
               .build();
    }
    private Category MapCategoryRequest(CategoryRequest categoryRequest)
    {
        return Category.builder()
                .title(categoryRequest.title())
                .description(categoryRequest.description())
                .build();
    }
    private Category getCategoryByid(int id)
    {
        return categoryProductRepository.getAllCategory().stream()
                .filter(pro->pro.getId()==id).findFirst()
                .orElseThrow(()->new HttpMessageConversionException("Category id="+id+"not found"));
    }
    @Override
    public List<CategoryRespone> getAllCategory(String name) {
      var getCategory=categoryProductRepository.getAllCategory();
        if (!name.isEmpty())
        {
           getCategory= getCategory.stream().filter(
                    category->category.getTitle().toLowerCase().contains(name.toLowerCase())
            ).toList();
        }
       return categoryProductRepository.getAllCategory()
               .stream().map(this::MapCategoryResopne).toList();
    }
    @Override
    public CategoryRespone deleteCategory(int id) {
        var categoryFind=getCategoryByid(id);
        categoryProductRepository.getAllCategory().remove(categoryFind);
        return MapCategoryResopne(categoryFind);
    }

    @Override
    public CategoryRespone createCategory(CategoryRequest categoryRequest) {
         var category=MapCategoryRequest(categoryRequest);
         categoryProductRepository.addCategory(category);
         return MapCategoryResopne(category);
    }

    @Override
    public CategoryRespone updateCategory(int id, CategoryRequest categoryRequest) {
      var getCategory=getCategoryByid(id);
      getCategory.setTitle(categoryRequest.title());
      getCategory.setDescription(categoryRequest.description());
      return MapCategoryResopne(getCategory);
    }

    @Override
    public CategoryRespone getCategory(int id) {
        var getGetegory=getCategoryByid(id);
        return MapCategoryResopne(getGetegory);
    }
}
