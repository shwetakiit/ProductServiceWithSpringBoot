package kumari.shweta.productservice.model;

import lombok.Getter;
import lombok.Setter;

//Used lombok library for getter setter
@Getter
@Setter
public class Product {
    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private Category category;

}
