package it.ropelato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath*:dwr-config.xml")
public class DurabilityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DurabilityApplication.class, args);
    }

}
