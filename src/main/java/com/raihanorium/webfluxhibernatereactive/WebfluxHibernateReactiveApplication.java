package com.raihanorium.webfluxhibernatereactive;

import com.raihanorium.webfluxhibernatereactive.model.Member;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.Configuration;
import org.hibernate.reactive.mutiny.Mutiny;
import org.hibernate.reactive.provider.ReactiveServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WebfluxHibernateReactiveApplication {

    @Nonnull
    private final MysqlConfiguration mysqlConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(WebfluxHibernateReactiveApplication.class, args);
    }

    @Bean
    public Mutiny.SessionFactory sessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperties(mysqlConfiguration.getProperties());
        configuration.addAnnotatedClass(Member.class);
        ServiceRegistry serviceRegistry = new ReactiveServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry).unwrap(Mutiny.SessionFactory.class);
    }
}
