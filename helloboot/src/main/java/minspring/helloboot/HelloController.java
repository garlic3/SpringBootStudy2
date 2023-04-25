package minspring.helloboot;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequestMapping("/hello")
@RestController
public class HelloController  {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public String hello(String name) {
//        return helloService.sayHello(Objects.requireNonNull(name));

        if(name == null || name.trim().length() == 0){
            throw new IllegalArgumentException();
        }
        return helloService.sayHello(name);
    }

    // 응답결과 :
    // status : 200
    // Content-Type : text/plain;charset=UTF-8
    // content : Hello spring


}
