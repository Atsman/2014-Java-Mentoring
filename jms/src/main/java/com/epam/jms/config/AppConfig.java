package com.epam.jms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Aleh_Atsman on 2/9/2015.
 */
@Configuration
@ComponentScan({"com.epam.jms.service"})
@Import({JmsConfig.class})
public class AppConfig {
}
