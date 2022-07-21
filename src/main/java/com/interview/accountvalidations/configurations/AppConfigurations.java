package com.interview.accountvalidations.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Configuration
public class AppConfigurations {

    @Bean
    public RestTemplate createAppRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public Random randomBean(){
        return new Random();
    }

}
