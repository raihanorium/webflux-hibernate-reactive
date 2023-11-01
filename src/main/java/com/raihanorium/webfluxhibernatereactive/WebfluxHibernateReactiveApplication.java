package com.raihanorium.webfluxhibernatereactive;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.reactive.mutiny.Mutiny;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebfluxHibernateReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxHibernateReactiveApplication.class, args);
    }

    @Bean
    public Mutiny.SessionFactory sessionFactory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql-pu", MysqlPersistenceUnit.getProperties());
        return entityManagerFactory.unwrap(Mutiny.SessionFactory.class);
    }
}
