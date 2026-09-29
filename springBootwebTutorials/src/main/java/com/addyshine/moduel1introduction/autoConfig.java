package com.addyshine.moduel1introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class autoConfig {
    @Bean
    public paymentService  paymentService() {
         return new paymentService();
    }

}
