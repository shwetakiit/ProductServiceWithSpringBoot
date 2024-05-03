package kumari.shweta.productservice.repositories;

import kumari.shweta.productservice.model.Product;
import kumari.shweta.productservice.projections.ProductWithTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {

    @Override
    Optional<Product> findById(Long id);

    List<Product> findByTitle(String title);

    List<Product> findByTitleContaining(String title);

    List<Product> findByTitleAndDescription(String title, String desc);

    Optional<Product> findByImage(String url);

    @Override
    void delete(Product entity);

    Product save(Product entity);//Create and update we have single method
    //HQL

    @Query("select p.title as title,p.description  as description from Product p where p.id=:id")
     ProductWithTitleAndDescription  randomQuery(@Param("id") Long id);

    //SQL Query --> Native Query
    @Query(value="select title,description from product where id =:id",nativeQuery = true)
     ProductWithTitleAndDescription  randomSQLQuery(@Param("id") Long id);


}
