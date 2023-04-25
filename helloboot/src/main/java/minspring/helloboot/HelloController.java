package minspring.helloboot;

public class HelloController {
    public String hello(String name){
        return "Hello " + name;
    }

    // 응답결과 :
    // status : 200
    // Content-Type : text/plain;charset=UTF-8
    // content : Hello spring
}
