package minspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {

    @Test
    void helloApi(){
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/app/hello?name={name}", String.class, "spring");

        // status code 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        // Header(Content-type) : text/plain
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello spring
        assertThat(res.getBody()).isEqualTo("*Hello spring*");

    }

    @Test
    void failHelloApi(){
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/app/hello?name=", String.class);

        // INTERNAL_SERVER_ERROR : 버그, 서버에 심각한 에러
        // status code 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
