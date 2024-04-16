package kumari.shweta.productservice.service;

import kumari.shweta.productservice.dto.FakeStoreProductDTO;
import kumari.shweta.productservice.model.Category;
import kumari.shweta.productservice.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service  //This service annotation we create object of FakeStoreProductService at  the time of intialization
public class FakeStoreProductService implements ProductService {
    RestTemplate restTemplate;

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

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
