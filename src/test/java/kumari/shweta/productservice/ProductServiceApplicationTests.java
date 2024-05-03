package kumari.shweta.productservice;

import ch.qos.logback.core.net.SyslogOutputStream;
import kumari.shweta.productservice.model.Category;
import kumari.shweta.productservice.model.Product;
import kumari.shweta.productservice.projections.ProductWithTitleAndDescription;
import kumari.shweta.productservice.repositories.CategoryRepository;
import kumari.shweta.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;
	//@Autowired
	private ProductWithTitleAndDescription productWithTitleAndDescription;
	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	public void testListOfProductInCategoryLoading() {
		Optional<Category> optionalCategory = categoryRepository.findById(1L);
		Category category = optionalCategory.get();
		System.out.println("Fetching product related to above Category");
		List<Product> productList = category.getProductList();
		//	System.out.println(productList.get(0).getTitle());
		ProductWithTitleAndDescription product = productRepository.randomQuery(1L);
		System.out.println("DEBUG");
		System.out.println(product.getTitle());
		System.out.println(product.getDescription());
		//System.out.println(product.getPrice());

		ProductWithTitleAndDescription product1 = productRepository.randomQuery(1L);
		System.out.println("DEBUG");
		System.out.println(product1.getTitle());
		System.out.println(product1.getDescription());


	}
}
