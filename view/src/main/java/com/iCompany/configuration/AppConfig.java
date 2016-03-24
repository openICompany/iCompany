package com.iCompany.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by lukasz on 23.03.16.
 */
@Configuration
@ComponentScan("com.iCompany")
@Import(ServicesConfiguration.class)
public class AppConfig {

    @Bean
    public ServicesConfiguration servicesConfiguration() {
        return new ServicesConfiguration();
    }
}
