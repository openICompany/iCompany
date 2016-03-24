package com.iCompany.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Lukasz Franczuk on 17.02.16.
 */
@Configuration
@Import(JPARepositoriesConfiguration.class)
public class ServicesConfiguration {
}
