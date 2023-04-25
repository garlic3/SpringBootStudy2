package minspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class HellobootApplication {

	@Bean
	public ServletWebServerFactory servletWebServerFactory(){
		return  new TomcatServletWebServerFactory();
	}

	@Bean
	public DispatcherServlet dispatcherServlet(){
		return new DispatcherServlet();
	}

	public static void main(String[] args) {

		// 스프링 컨테이너
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();

				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);

				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					// 서블릿 등록
					servletContext.addServlet("dispatcherServlet", dispatcherServlet).addMapping("/*"); // 서블릿 매핑

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
