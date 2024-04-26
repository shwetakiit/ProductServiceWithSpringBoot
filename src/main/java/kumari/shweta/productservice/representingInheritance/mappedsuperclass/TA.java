package kumari.shweta.productservice.representingInheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name="MSC_TA")
public class TA  extends User{

    private int numberOfSessions;
    private double averageRating;
}
