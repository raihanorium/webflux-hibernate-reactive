package com.raihanorium.webfluxhibernatereactive;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@RequiredArgsConstructor
public class MysqlConfiguration {

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String jdbcUser;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    public Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.connection.url", jdbcUrl);
        properties.put("hibernate.connection.username", jdbcUser);
        properties.put("hibernate.connection.password", jdbcPassword);

        // Schema generation
        properties.put("jakarta.persistence.schema-generation.database.action", "drop-and-create");

        // SQL statement logging
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.highlight_sql", "true");
        properties.put("jakarta.persistence.sql-load-script-source", "data.sql");

        return properties;
    }
}
