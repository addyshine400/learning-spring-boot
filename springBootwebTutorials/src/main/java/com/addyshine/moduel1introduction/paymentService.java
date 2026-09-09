package com.addyshine.moduel1introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class paymentService {
    public void pay(){

        System.out.println("paying the amount...");
    }

    @PostConstruct
    public void afterCreation(){
        System.out.println(" before payment...");
    }

    @PreDestroy
    public void breforeDestroy(){
        System.out.println(" after payment...");
    }


}
