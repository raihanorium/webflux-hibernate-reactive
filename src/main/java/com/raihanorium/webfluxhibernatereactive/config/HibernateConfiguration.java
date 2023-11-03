package com.raihanorium.webfluxhibernatereactive.config;

import com.raihanorium.webfluxhibernatereactive.model.Member;
import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.reactive.provider.ReactiveServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfiguration {
    @Bean
    public Mutiny.SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(Member.class);

        ServiceRegistry serviceRegistry = new ReactiveServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        return configuration
                .buildSessionFactory(serviceRegistry)
                .unwrap(Mutiny.SessionFactory.class);
    }
}
