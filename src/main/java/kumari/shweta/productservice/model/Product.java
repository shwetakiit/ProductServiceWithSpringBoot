package kumari.shweta.productservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//Used lombok library for getter setter
@Getter
@Setter
@Entity
public class Product extends  BaseModel {

    private String title;
    private String description;
    private double price;
    private String image;
    private int qty;
    @ManyToOne(cascade = CascadeType.PERSIST) //Note If we post the request of product with same category id which available in DB we will get error  detached entity passed to persist: kumari.shweta.productservice.model.Category .To avoid this error use Casecadetype -->MERGE or ALL better to use Merge
    private Category category;

    /*
    1    -->  1  One Product has many category
     product ---- Category    ==> M :1
     M  <--  1  In one category there is many product
   */

}
