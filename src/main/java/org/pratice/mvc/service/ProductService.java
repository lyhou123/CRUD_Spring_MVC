package org.pratice.mvc.service;
import org.pratice.mvc.dto.ProductRequest;
import org.pratice.mvc.model.Product;
import org.pratice.mvc.dto.ProductRespone;
import java.util.List;
import java.util.Scanner;

public interface ProductService {
  List<ProductRespone> productResponeList();
  ProductRespone deleteProduct(int id);
 ProductRespone creatProduct(ProductRequest productRequest);
  ProductRespone updateProduct(int id,ProductRequest productRequest);
  ProductRespone getProduct(int id);
}
