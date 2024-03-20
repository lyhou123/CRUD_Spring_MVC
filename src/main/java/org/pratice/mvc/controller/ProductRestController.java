package org.pratice.mvc.controller;
import lombok.RequiredArgsConstructor;
import org.pratice.mvc.dto.ProductRequest;
import org.pratice.mvc.dto.ProductRespone;
import org.pratice.mvc.model.Product;
import org.pratice.mvc.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;
    private Map<String ,Object> respone(Object object,String message,int status)
    {
       HashMap <String,Object> respone=new HashMap<>();
         respone.put("payload",object);
            respone.put("message",message);
            respone.put("status",status);
            return respone;
    }

    @GetMapping("/getAll")
    public Map<String, Object> getAllProduct(@RequestParam (defaultValue = "") String name) {
       return respone(productService.productResponeList(name),"success", HttpStatus.OK.value());
    }
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteProduct(@PathVariable int id) {
        return respone(productService.deleteProduct(id), "success", HttpStatus.OK.value());
    }

    @PostMapping("/create")
    public Map<String, Object> createProduct(@RequestBody ProductRequest productRequest) {
    return respone(productService.creatProduct(productRequest), "Delete success", HttpStatus.OK.value());
    }

    @GetMapping("/{id}")
    public Map<String, Object> getProduct(@PathVariable int id) {
        return respone(productService.getProduct(id), "success", HttpStatus.OK.value());
        }
     @PutMapping("/{id}")
    public Map<String,Object> UpdateProduct(@PathVariable int id,@RequestBody ProductRequest productRequest)
     {
        return respone(productService.updateProduct(id,productRequest),"Update success",HttpStatus.OK.value());
     }

}