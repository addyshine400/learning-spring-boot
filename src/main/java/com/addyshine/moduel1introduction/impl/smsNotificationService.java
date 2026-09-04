package com.addyshine.moduel1introduction.impl;


import com.addyshine.moduel1introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SMSnotify")
public class smsNotificationService implements NotificationService {
  @Override
  public void send(String message) {
    System.out.println("SMS Notification Service: " + message);
  }
}
