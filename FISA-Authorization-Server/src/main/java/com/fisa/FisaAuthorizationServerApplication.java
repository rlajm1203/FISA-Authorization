package com.fisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "com.fisa")
public class FisaAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FisaAuthorizationServerApplication.class, args);
    }

}
