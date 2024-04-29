package kumari.shweta.productservice.representingInheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import kumari.shweta.productservice.representingInheritance.mappedsuperclass.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "3")
public class TA extends User {

    private int numberOfSessions;
    private double averageRating;
}
