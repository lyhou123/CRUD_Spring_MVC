package org.pratice.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.pratice.mvc.dto.CategoryRequest;
import org.pratice.mvc.service.CategoryService;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
@Primary
public class CategoryController {
    private final CategoryService categoryService;
    private Map<String,Object> response(Object objecr,String message,int status)
    {
        Map<String,Object> response = new HashMap<>();
        response.put("data",objecr);
        response.put("message",message);
        response.put("status", status);
        return response;
    }
    @GetMapping("/getAll")
    public Map<String,Object> getAllCategory(@RequestParam (defaultValue = "") String name){
        return response(categoryService.getAllCategory(name),"Successfully",HttpStatus.OK.value());
    }
    @DeleteMapping("/{id}")
    public Map<String,Object> DeleteCategory(@PathVariable int id)
    {
        categoryService.deleteCategory(id);
        return response(new ArrayList<>(),"Delete Successfully",HttpStatus.OK.value());
    }
    @PutMapping("/{id}")
    public Map<String,Object> UpdateCategory(@PathVariable int id, CategoryRequest categoryRequest)
    {
       return response(categoryService.updateCategory(id, categoryRequest),"Update Successfully",HttpStatus.OK.value());
    }
    @PostMapping("/create")
    public Map<String,Object> CreateCategory(@RequestBody  CategoryRequest categoryRequest)
    {
        return response(categoryService.createCategory(categoryRequest),"Insert Successfully",HttpStatus.OK.value());
    }
    @GetMapping("/{id}")
    public Map<String,Object> CategoryById(@PathVariable int id)
    {
        return response(categoryService.getCategory(id),"Successfully",HttpStatus.OK.value());
    }
}
