package com.clean.example.configuration;

import com.clean.example.dataproviders.database.SimianHumanDataprovider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseDataProviderConfiguration {

    @Bean
    public SimianHumanDataprovider getSimianHumanDataprovider(JdbcTemplate jdbcTemplate) {
        return new SimianHumanDataprovider(jdbcTemplate);
    }

}
