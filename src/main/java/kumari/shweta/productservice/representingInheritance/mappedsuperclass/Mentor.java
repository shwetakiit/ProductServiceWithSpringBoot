package kumari.shweta.productservice.representingInheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="MSC_MENTOR")
public class Mentor extends User{
    private  double mentorRating;
}
