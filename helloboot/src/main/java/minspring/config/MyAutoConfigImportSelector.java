package minspring.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                "minspring.config.autoconfig.DispatcherServletConfig",
                "minspring.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
