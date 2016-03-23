package com.iCompany.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Lukasz Franczuk on 17.02.16.
 */
@Configuration
@EnableJpaRepositories(
        basePackages = {"com.iCompany.repositories"}
)
@Import(JPAConfiguration.class)
public class JPARepositoriesConfiguration {
}
