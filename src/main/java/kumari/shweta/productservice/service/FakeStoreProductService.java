package kumari.shweta.productservice.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import kumari.shweta.productservice.dto.FakeStoreProductDTO;
import kumari.shweta.productservice.model.Category;
import kumari.shweta.productservice.model.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service  //This service annotation we create object of FakeStoreProductService at  the time of intialization
public class FakeStoreProductService implements ProductService {
    RestTemplate restTemplate;

    //Update Fake api with given with DTO attribute and return updated value
    @Override
    public Product replaceProduct(Long id, Product product) {


        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setImage(product.getImage());
        fakeStoreProductDTO.setDescription(product.getDescription());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor<>(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreDTOtoProduct(response);
    }

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Convert DTO to Product as response .
     *
     * @param fakeStoreProductDTO
     * @return
     */
    private Product convertFakeStoreDTOtoProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImage(fakeStoreProductDTO.getImage());
        Category category = new Category();
        category.setDesc(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product getProductByID(Long Id) {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + Id, FakeStoreProductDTO.class);
        //1st parameter -url and 2nd parameter -Response
        //Convert DTO into product object
        if (fakeStoreProductDTO == null) {
            return null;
        }
        return convertFakeStoreDTOtoProduct(fakeStoreProductDTO);

    }

    /**
     * Get all products
     * @return
     */
    @Override
    public List<Product> getAllProducts() {
   FakeStoreProductDTO[] fakeStoreProductDTOS=
        restTemplate.getForObject("https://fakestoreapi.com/products/",FakeStoreProductDTO[].class  );
        System.out.println("DEBUG");
            if(fakeStoreProductDTOS==null){
                return null;
            }
            List<Product> response = new ArrayList<>();
       for(FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOS){
           response.add(convertFakeStoreDTOtoProduct(fakeStoreProductDTO));
       }
        return response;
    }
}
