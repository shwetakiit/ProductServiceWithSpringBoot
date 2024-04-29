package kumari.shweta.productservice.representingInheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@DiscriminatorValue(value ="2")
@Entity
public class Mentor extends User {
    private double mentorRating;


}