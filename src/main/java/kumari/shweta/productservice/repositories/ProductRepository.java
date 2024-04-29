package kumari.shweta.productservice.repositories;

import kumari.shweta.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {

    @Override
    Optional<Product> findById(Long id);
  List<Product>  findByTitle(String title);
  List<Product>  findByTitleContaining(String title);
   List<Product>   findByTitleAndDescription(String title,String desc);
   Optional<Product> findByImage(String url);

    @Override
    void delete(Product entity);
    Product save(Product entity);//Create and update we have single method
}
