package com.epam.mentoring.spring.configuration;

import com.epam.mentoring.spring.factory.impl.FactoryBeanImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by alehatsman on 12/17/14.
 */
@Configuration
@ComponentScan("com.epam")
@PropertySource("classpath:props.properties")
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "factoryBean")
    public static FactoryBean factoryBean() {
        return new FactoryBeanImpl();
    }

}
