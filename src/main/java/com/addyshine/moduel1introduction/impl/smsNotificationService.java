package com.addyshine.moduel1introduction.impl;


import com.addyshine.moduel1introduction.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class smsNotificationService implements NotificationService {
  @Override
  public void send(String message) {
    System.out.println("SMS Notification Service: " + message);
  }
}
