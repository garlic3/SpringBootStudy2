package minspring.helloboot;

import minspring.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class HellobootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class, args);

		// 사용자 구성정보 (Component Scan)
		// SimpleHelloService, HelloController, HelloDecorator

		// 자동 구성정보 (Auto Configuration)
		// TomcatServletWebServletFactory, DispatcherServlet (MyAutoConfiguration.imports)


	}


}
