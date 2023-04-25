package minspring.helloboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class HellobootApplication {

	public static void main(String[] args) {
		// 스프링 컨테이너
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
		// 메타정보를 통해 빈 등록
		applicationContext.registerBean(HelloController.class);
		applicationContext.registerBean(SimpleHelloService.class);
		// 초기화
		applicationContext.refresh();

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			// 서블릿 등록
			servletContext.addServlet("dispatcherServlet",new DispatcherServlet(applicationContext)).addMapping("/*"); // 서블릿 매핑

		});
		// 톰캣 서블릿 컨테이너 시작
		webServer.start();

	}

}
