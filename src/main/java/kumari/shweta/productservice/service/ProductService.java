package kumari.shweta.productservice.service;

import kumari.shweta.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product getProductByID(Long Id);

    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);

}
