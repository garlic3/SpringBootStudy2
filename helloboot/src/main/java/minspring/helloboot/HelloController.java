package minspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name){
        return "Hello " + name;
    }

    // 응답결과 :
    // status : 200
    // Content-Type : text/plain;charset=UTF-8
    // content : Hello spring
}
