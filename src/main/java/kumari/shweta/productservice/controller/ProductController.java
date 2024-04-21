package kumari.shweta.productservice.controller;

import kumari.shweta.productservice.model.Product;
import kumari.shweta.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductByID(id);
        ResponseEntity<Product>  responseEntity;
        if(product==null){
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return  responseEntity;
        }
       responseEntity= new ResponseEntity<>(product,HttpStatus.OK);
        return  responseEntity;
    }

    //localhost://8080/products
    @GetMapping
    public List<Product> getAllProducts(){
     return productService.getAllProducts();
    }
    //createPRODUCT
    //deleteProduct
    //updateProduct --Partial Update(PATCH)
    //replaceProduct--> Replace

/*

    {

        "title":"update fake API ",
            " description":"shweta",
            " image":"https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg"
    }


    */

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }
}
