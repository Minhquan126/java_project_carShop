package rickkeiAcademy.controller;


import rickkeiAcademy.model.product.Product;
import rickkeiAcademy.service.productService.IProductService;
import rickkeiAcademy.service.productService.ProductServiceIMPL;

import java.util.List;

public class ProductControl {
public IProductService productService = new ProductServiceIMPL();
public List<Product> getProducts(){
    return productService.fileAll();
}
public void createProduct(Product product){
    productService.save(product);
}
public void updateProduct(Product product){
    productService.save(product);
}
public void deleteProduct(int id){
    productService.deleteById(id);
}
public Product findById(int id){
  return  productService.findById(id);
}
}
