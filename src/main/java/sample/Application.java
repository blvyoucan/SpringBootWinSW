package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@SpringBootApplication
@ManagedResource(objectName=ApplicationShutdown.DEFAULT_OBJECT_NAME)
public class Application {
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
    }
    
    @ManagedOperation
    public void shutdown() {
        SpringApplication.exit(context);
        System.exit(0);
    }
}
