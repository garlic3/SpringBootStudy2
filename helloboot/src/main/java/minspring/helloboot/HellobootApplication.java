package minspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class HellobootApplication {

	@Bean
	public HelloController helloController(HelloService helloService){
		return new HelloController(helloService);
	}

	@Bean
	public HelloService helloService(){
		return new SimpleHelloService();
	}

	public static void main(String[] args) {

		// 스프링 컨테이너
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					// 서블릿 등록
					servletContext.addServlet("dispatcherServlet",new DispatcherServlet(this)).addMapping("/*"); // 서블릿 매핑

				});
				// 톰캣 서블릿 컨테이너 시작
				webServer.start();
			}
		};

		applicationContext.register(HellobootApplication.class);
		// 스프링 컨테이너 초기화
		applicationContext.refresh();

	}

}
