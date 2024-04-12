package kumari.shweta.productservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This controller will be containing HTTP API

@RestController
//localhost:8080/
//All the API's for /sample end point should come to this  controller.
@RequestMapping("/sample")
public class SampleController {
    //localhost:8080/sample/sayHello
    @GetMapping("/sayHello")
public String  sayHello(){
    return "Testing project setup";
}
}
