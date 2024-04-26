package kumari.shweta.productservice.representingInheritance.joinedTable;

import jakarta.persistence.Entity;
import kumari.shweta.productservice.representingInheritance.mappedsuperclass.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name="JT_INSTRUCTOR")  //This is child of mapped super class
public class Instructor extends User {

    private  String specialization;

}
