package kumari.shweta.productservice.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class UserDTO {

    private String name;
    private String email;
    private String password;
    private List<Role> roles;

}
