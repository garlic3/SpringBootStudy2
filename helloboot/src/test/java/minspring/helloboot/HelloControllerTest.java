package minspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloControllerTest {

    @Test
    void helloControllerTest(){
        HelloController helloController = new HelloController(name -> name);
        String ret = helloController.hello("Test");
        Assertions.assertThat(ret).isEqualTo("Test");

    }

    @Test
    void failsHelloControllerTest(){
        HelloController helloController = new HelloController(name -> name);

        // null 값 테스트
        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        // 빈 문자열 테스트
        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
