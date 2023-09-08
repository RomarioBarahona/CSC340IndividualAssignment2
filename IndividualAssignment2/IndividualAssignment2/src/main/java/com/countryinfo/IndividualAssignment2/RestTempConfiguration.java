package com.countryinfo.IndividualAssignment2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//RestTemplate Configurations
@Configuration
public class RestTempConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}