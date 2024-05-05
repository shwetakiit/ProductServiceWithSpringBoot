package kumari.shweta.productservice.model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String title;


/*
If  mapping done  both side in Product ->ManyToOne with Category and in Category -> OneToMANY for List of product It create the category_id in
product table but It also create mapping table with category_id and product_id.Which is not useful and that's why we keep mapping in one side that is MayToOne

If we keep Only OneToMany -It creates mapping table and no product_id in Category table and Of course there is no Category_Id in product table
 If we keep both side mapping in OneToMany mapping use mapped by --> It doesn't create mapping table and catergory_id  will be available in product table
*/
@OneToMany(mappedBy = "category")
private List<Product> productList;


}
