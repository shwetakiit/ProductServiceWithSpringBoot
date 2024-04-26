package kumari.shweta.productservice.representingInheritance.joinedTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//If parent class inheritance type is joinedTable in that case It create table for each entity Parent and Child
@Inheritance(strategy = InheritanceType.JOINED) //Multiple way to do something we use Strategy design pattern
@Entity(name="JT_USER")
public class User {
    @Id
    private Long id;
    private  String name ;
    private  String email;
    private  String password;

}
