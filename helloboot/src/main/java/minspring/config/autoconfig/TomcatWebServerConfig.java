package minspring.config.autoconfig;

import minspring.config.ConditionalMyOnClass;
import minspring.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @Bean("tomcatServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(){
        return  new TomcatServletWebServerFactory();
    }

}
