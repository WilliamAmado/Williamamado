package com.usa.reto3v2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Reto3v2Application {

    public static void main(String[] args) {
        SpringApplication.run(Reto3v2Application.class, args);
        System.out.println("Ejecucion Exitosa");
    }



}
