package hu.unideb.inf.java.jpa.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfigurationDataSource {

    private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/example?createDatabaseIfNotExist=true";

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(dbUrl,"root","");
    }
}
