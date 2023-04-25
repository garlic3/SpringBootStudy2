package minspring.helloboot;

import org.springframework.boot.SpringApplication;

@MySpringBootAnnotation
public class HellobootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class, args);

		// 사용자 구성정보 (Component Scan)
		// 자동 구성정보 (Auto Configuration)
		// TomcatServletWebServletFactory, DispatcherServlet

	}


}
