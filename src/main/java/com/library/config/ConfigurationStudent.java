package com.library.config;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ConfigurationStudent {


    @Bean
    public TestRestTemplate testRestTemplate() {
        return new TestRestTemplate();
    }



}
