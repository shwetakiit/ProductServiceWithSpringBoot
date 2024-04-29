package kumari.shweta.productservice.representingInheritance.joinedTable;

import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name="JT_TA")
public class TA extends User {

    private int numberOfSessions;
    private double averageRating;
}
