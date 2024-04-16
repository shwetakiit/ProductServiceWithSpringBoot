package kumari.shweta.productservice.controller;

import kumari.shweta.productservice.model.Product;
import kumari.shweta.productservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//localhost://8080/products
@RestController//This controller is going to host rest http API
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    /*If we don't annotate Service class @Service It will show error here due to Spring required object to pass
    Sprint will not create object automatically we need to tell to sprint to create object at the time of intilization
    so we need to annotate service class with @Service*/
    ProductController(ProductService productService) {
        this.productService=productService;
    }

    //localhost://8080/products/1
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductByID(id);
    }

    //localhost://8080/products
    @GetMapping
    public List<Product> getAllProducts(){
     return new ArrayList<>();
    }
    //createPRODUCT
    //deleteProduct
    //updateProduct --Partial Update(PATCH)
    //replaceProduct--> Replace

}
