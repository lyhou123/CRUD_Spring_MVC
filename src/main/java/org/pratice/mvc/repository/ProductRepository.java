package org.pratice.mvc.repository;

import org.pratice.mvc.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {
   private final List<Product> productList=new ArrayList<>(){{
       add(Product.builder().id(1).title("title1").description("description1")
               .price(100).imageUrl("image1").build());
       add(Product.builder().id(2).title("title2").description("description2")
               .price(100).imageUrl("image2").build());
       add(Product.builder().id(3).title("title3").description("description3")
               .price(100).imageUrl("image3").build());
   }};
   public List<Product> getAllProduct()
   {
       return productList;
   }
   public void addProduct(Product product)
   {
       productList.add(product);
   }
}
