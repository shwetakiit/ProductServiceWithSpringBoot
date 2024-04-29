package kumari.shweta.productservice.model;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String title;


}
