package minspring.helloboot;

import java.util.Objects;

public class HelloController {
    public String hello(String name){
        SimpleHelloService helloService = new SimpleHelloService();
        return helloService.sayHello(Objects.requireNonNull(name));
    }

    // 응답결과 :
    // status : 200
    // Content-Type : text/plain;charset=UTF-8
    // content : Hello spring
}
