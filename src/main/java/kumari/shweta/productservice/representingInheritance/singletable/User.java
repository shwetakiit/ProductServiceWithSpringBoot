package kumari.shweta.productservice.representingInheritance.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//Only one table create If Parent class Inheritance type is SINGLE_TYPE .Differentiate  child classes with  data with Discriminator value.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="USER_TYPE",
                      discriminatorType = DiscriminatorType.INTEGER
)
@Entity(name="ST_USER")
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private Long id;
    private  String name ;
    private  String email;
    private  String password;

}
