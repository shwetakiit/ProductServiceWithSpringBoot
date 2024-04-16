package kumari.shweta.productservice.dto;

import kumari.shweta.productservice.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    //All these attribute is taken w.r.t fake api json response
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category; //In json response Category is string not object
}
