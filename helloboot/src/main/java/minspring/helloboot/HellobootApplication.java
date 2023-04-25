package minspring.helloboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
public class HellobootApplication {

	public static void main(String[] args) {
		// 스프링 컨테이너
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		// 메타정보를 통해 빈 등록
		applicationContext.registerBean(HelloController.class);
		applicationContext.registerBean(SimpleHelloService.class);
		// 초기화
		applicationContext.refresh();

		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			// 서블릿 등록
			servletContext.addServlet("hello", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
					// 매핑
					if (req.getRequestURI().equals("/hello") && req .getMethod().equals(HttpMethod.GET.name())) {
						// 바인딩
						String name = req.getParameter("name");
						// 빈 가져오기
						HelloController helloController = applicationContext.getBean(HelloController.class);
						// 작업 위임
						String ret = helloController.hello(name);
						// 응답 생성
						resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(ret);
					}
					else {
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*"); // 서블릿 매핑

		});
		// 톰캣 서블릿 컨테이너 시작
		webServer.start();

	}

}
