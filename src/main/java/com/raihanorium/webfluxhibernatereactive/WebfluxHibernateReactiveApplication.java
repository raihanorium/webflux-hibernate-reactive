package com.raihanorium.webfluxhibernatereactive;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WebfluxHibernateReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxHibernateReactiveApplication.class, args);
    }
}
