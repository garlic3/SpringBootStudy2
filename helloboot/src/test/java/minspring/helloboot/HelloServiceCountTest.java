package minspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.stream.IntStream;

@HellobootTest
public class HelloServiceCountTest {

    @Autowired
    HelloService helloService; // 테스트용
    @Autowired
    HelloRepository helloRepository; // 테스트 검증용

    @Test
    void sayHelloIncreaseCount() {
        IntStream.rangeClosed(1, 10).forEach(count -> {
            helloService.sayHello("min");
            Assertions.assertThat(helloRepository.countOf("min")).isEqualTo(count);
        });


    }
}
