package kumari.shweta.productservice.service;

import kumari.shweta.productservice.model.Category;
import kumari.shweta.productservice.model.Product;
import kumari.shweta.productservice.repositories.CategoryRepository;
import kumari.shweta.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements  ProductService{
    private  ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductByID(Long Id) {
        //Fetch the  product with given id from DB.
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        //Before saving the product Object in DB ,Save the Category object .
        Category category= product.getCategory();
        if(category.getId()==null){
            //We need to save category
           Category savedCategory= categoryRepository.save(category);
           product.setCategory(savedCategory);

        } else {
            //We should check if the category id is valid or not .

        }

      Product savedProduct=  productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(savedProduct.getCategory().getId());
        Category category1 = optionalCategory.get();
        savedProduct.setCategory(category1);
        return savedProduct;


    }

    @Override
    public void deleteProduct() {

    }
}
