package minspring.config.autoconfig;

import minspring.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MyAutoConfiguration
public class TomcatWebServerConfig {

    @Bean("tomcatServerFactory")
    public ServletWebServerFactory servletWebServerFactory(){
        return  new TomcatServletWebServerFactory();
    }
}
