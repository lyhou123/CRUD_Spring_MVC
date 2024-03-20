package org.pratice.mvc.repository;

import org.pratice.mvc.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryProductRepository {
    private List<Category> categories=new ArrayList<>(){{
       add(Category.builder()
               .id(1)
                       .title("Fruits")
                               .description("Fruits").
               build());
         add(Category.builder()
                 .id(2)
                 .description("Vegetables")
                 .title("fruit")
                 .build());
    }};
    public List<Category> getAllCategory()
    {
        return categories;
    }
    public void addCategory(Category category)
    {
        categories.add(category);
    }

}
