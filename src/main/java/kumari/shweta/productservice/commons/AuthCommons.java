package kumari.shweta.productservice.commons;

import kumari.shweta.productservice.dto.UserDTO;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthCommons {

    private RestTemplate restTemplate;

    public AuthCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO validateToken(String tokenValue){


        //Call the userservice to validate the token
        ResponseEntity<UserDTO> responseEntity = restTemplate.getForEntity("http://localhost:4141/users/validate/"+tokenValue, UserDTO.class);
        if(responseEntity.getBody()==null){
            return null;
        }
        return responseEntity.getBody();

    }

}
