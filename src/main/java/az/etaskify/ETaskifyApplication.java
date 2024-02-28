package az.etaskify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"az.etaskify.security"})
public class ETaskifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ETaskifyApplication.class, args);
    }

}
