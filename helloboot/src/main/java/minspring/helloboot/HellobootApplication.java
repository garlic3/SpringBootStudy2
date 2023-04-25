package minspring.helloboot;

import minspring.config.MySpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
public class HellobootApplication {

//	@Bean
//	ApplicationRunner applicationRunner(Environment env){
//		return args -> {
//			String name =  env.getProperty("my.name");
//			System.out.println("my name: " + name);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(HellobootApplication.class, args);

		// 사용자 구성정보 (Component Scan)
		// SimpleHelloService, HelloController, HelloDecorator

		// 자동 구성정보 (Auto Configuration)
		// TomcatServletWebServletFactory, DispatcherServlet (MyAutoConfiguration.imports)


	}


}
