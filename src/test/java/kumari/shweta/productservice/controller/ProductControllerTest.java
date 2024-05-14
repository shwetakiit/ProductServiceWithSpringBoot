package kumari.shweta.productservice.controller;

import kumari.shweta.productservice.model.Product;
import kumari.shweta.productservice.repositories.ProductRepository;
import kumari.shweta.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest//If we want to use spring functionality
class ProductControllerTest {

    @Autowired
    private ProductController productController;

   @MockBean //This is going to be a mock object. If we annotate with Autowire It will call actual object of product with id 1L
    private ProductService productService;

    @Test
    void validGetProductByIdTest()  {
        Product product = new Product();
        product.setTitle("Macbook Pro");
        product.setPrice(150000.0);
        when(productService.getProductByID(1L)).thenReturn(product);//If you are calling product with id 1L ,It will call mock product

        ResponseEntity<Product> responseEntity = productController.getProductById(1L);
        Product actualProduct = responseEntity.getBody();
        assertEquals(product,actualProduct);

    }
    @Test
    void getAllProductsTest()  {

        List<Product> expectedProducts = new ArrayList<>();

        Product p1 = new Product();
        p1.setTitle("Macbook Pro");
        p1.setId(1L);

        Product p2 = new Product();
        p2.setId(2L);
        p2.setTitle("Macbook Pro2");

        Product p3 = new Product();
        p3.setId(3L);
        p3.setTitle("Macbook Pro3");
        expectedProducts.add(p1);
        expectedProducts.add(p2);
        expectedProducts.add(p3);

        when(productService.getAllProducts()).thenReturn(expectedProducts);

        List<Product> productList = productController.getAllProducts();

        //Way 1
        assertIterableEquals(expectedProducts,productList);

        /*  Way 2 Compare objects manually */
        if(expectedProducts.size()==productList.size()){

            for(int i=0;i<expectedProducts.size();i++){
                assertTrue(productList.get(i).getId()==expectedProducts.get(i).getId());

            }

        }


    }
}