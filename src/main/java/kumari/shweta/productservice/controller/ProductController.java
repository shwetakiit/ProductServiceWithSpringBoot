package kumari.shweta.productservice.controller;

import kumari.shweta.productservice.commons.AuthCommons;
import kumari.shweta.productservice.dto.Role;
import kumari.shweta.productservice.dto.UserDTO;
import kumari.shweta.productservice.model.Product;
import kumari.shweta.productservice.repositories.ProductRepository;
import kumari.shweta.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//localhost://8080/products
@RestController//This controller is going to host rest http API
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private ProductService productService;
    private AuthCommons authCommons;

    /*If we don't annotate Service class @Service It will show error here due to Spring required object to pass
    Sprint will not create object automatically we need to tell to sprint to create object at the time of intilization
    so we need to annotate service class with @Service*/
    ProductController(@Qualifier("selfProductService") ProductService productService, ProductRepository productRepository,AuthCommons authCommons) {
        this.productService=productService;
        this.productRepository = productRepository;
        this.authCommons=authCommons;

    }

    //localhost://8080/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id,@RequestHeader("authToken") String token) {


        //Call UserService ValidateToken API to validate the token
        UserDTO userDTO= authCommons.validateToken(token);
        ResponseEntity<Product> responseEntity;
        if(userDTO==null){
            responseEntity= new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
            return  responseEntity;

        }
        //Role based access -Lets say If user has admin role that user can access product
      /*  for(Role role: userDTO.getRoles()){
            if(role.getValue().equals("ADMIN")){
             //Provide access
            }
        }*/

        Product product = productService.getProductByID(id);

        //    product = new Product(); --Test testcase fail scenario because we are creating different object of product

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
   /*
   To fail test case create objects which is different from mock object
    List<Product> products = List.of(new Product(),new Product(),new Product(),new Product());
    return  products;
    */
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

    @PostMapping
    public Product createProduct(@RequestBody  Product product){//Here we can use DTO as well.
        return productService.createProduct(product);
    }

    public void deleteProduct() {

    }
}
