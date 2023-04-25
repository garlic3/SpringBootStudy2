package minspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@HellobootTest
public class HelloRepositoryTest {

    @Autowired HelloRepository helloRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init(){
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }


    @Test
    void findHelloFailed(){
        assertThat(helloRepository.findHello("min")).isNull();

    }
    @Test
    void increaseCount(){

        assertThat(helloRepository.countOf("min")).isEqualTo(0);

        helloRepository.increaseCount("min");
        assertThat(helloRepository.countOf("min")).isEqualTo(1);

        helloRepository.increaseCount("min");
        assertThat(helloRepository.countOf("min")).isEqualTo(2);
    }
}
