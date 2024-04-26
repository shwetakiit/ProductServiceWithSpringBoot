package kumari.shweta.productservice.representingInheritance.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import kumari.shweta.productservice.representingInheritance.mappedsuperclass.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="JT_MENTOR")
@PrimaryKeyJoinColumn(name="user_id") //User_id column can be available in child table  of User as a foreign key
public class Mentor extends User {
    private  double mentorRating;
}
