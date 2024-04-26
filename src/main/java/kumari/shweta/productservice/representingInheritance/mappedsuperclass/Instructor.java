package kumari.shweta.productservice.representingInheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name="MSC_INSTRUCTOR")  //This is child of mapped super class
public class Instructor extends  User{

    private  String specialization;

}
