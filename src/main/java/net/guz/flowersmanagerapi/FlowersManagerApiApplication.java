package net.guz.flowersmanagerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("net.guz.flowersmanagerapi.repository")
@EntityScan("service.models")
public class FlowersManagerApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlowersManagerApiApplication.class, args);
    }

}
