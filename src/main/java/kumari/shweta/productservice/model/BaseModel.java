package kumari.shweta.productservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass //It means there is no table for parents class created ,Tables are created for child class .
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Moved ID from Product and category to parent Entity class because ID is common in Product and Category
    private Date createdAt;
    private Date updatedAt;
}
