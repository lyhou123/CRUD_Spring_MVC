package org.pratice.mvc.service;

import org.pratice.mvc.dto.CategoryRequest;
import org.pratice.mvc.dto.CategoryRespone;
import org.pratice.mvc.model.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryRespone> getAllCategory(String name);
    CategoryRespone deleteCategory(int id);
    CategoryRespone createCategory(CategoryRequest categoryRequest);
    CategoryRespone updateCategory(int id,CategoryRequest categoryRequest);
    CategoryRespone getCategory(int id);
}
