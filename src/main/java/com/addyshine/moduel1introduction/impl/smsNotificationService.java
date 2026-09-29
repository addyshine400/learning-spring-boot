package com.addyshine.moduel1introduction.impl;


import com.addyshine.moduel1introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SMSnotify")
//@ConditionalOnProperty(name = "notification.type" , havingValue = "sms")
public class smsNotificationService implements NotificationService {
  @Override
  public void send(String message) {

    System.out.println("SMS Notification Service: " + message);
  }
}
