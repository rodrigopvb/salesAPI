package org.github.rodrigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.github.rodrigo.repository")
@EntityScan(basePackages = "org.github.entity")
public class SalesApi {
    public static void main(String[] args) {
        SpringApplication.run(SalesApi.class, args);
    }
}
