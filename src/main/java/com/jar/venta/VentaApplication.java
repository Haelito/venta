package com.jar.venta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jar.venta.repository")
public class VentaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VentaApplication.class, args);
    }

}
