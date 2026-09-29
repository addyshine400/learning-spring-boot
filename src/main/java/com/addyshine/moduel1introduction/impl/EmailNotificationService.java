package com.addyshine.moduel1introduction.impl;

import com.addyshine.moduel1introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

 @Component
 @Qualifier("EMAILnotify")
 //@ConditionalOnProperty(name = "notification.type" , havingValue = "email")
public class EmailNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Email Notification Service: " + message);
    }
}
