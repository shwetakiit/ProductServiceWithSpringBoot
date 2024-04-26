package kumari.shweta.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    @ManyToOne
    private Category category;

    /*
    1    -->  1  One Product has many category
     product ---- Category    ==> M :1
     M  <--  1  In one category there is many product
   */

}
