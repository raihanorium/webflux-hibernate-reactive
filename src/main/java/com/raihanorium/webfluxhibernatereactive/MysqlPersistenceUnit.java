package com.raihanorium.webfluxhibernatereactive;

import jakarta.persistence.PersistenceUnit;

import java.util.Properties;

@PersistenceUnit(name = "mysql-pu")
public class MysqlPersistenceUnit {
    private static final String JDBC_URL = "jdbc:mysql://ideascale.me:3306/members";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "brewski01";

    public static Properties getProperties() {
        Properties properties = new Properties();
        properties.put("jakarta.persistence.jdbc.url", JDBC_URL);
        properties.put("jakarta.persistence.jdbc.user", JDBC_USER);
        properties.put("jakarta.persistence.jdbc.password", JDBC_PASSWORD);

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
