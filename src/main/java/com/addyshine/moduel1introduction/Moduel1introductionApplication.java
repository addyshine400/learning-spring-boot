package com.addyshine.moduel1introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class  Moduel1introductionApplication implements CommandLineRunner {
	//@Autowired
 //final	NotificationService notificationServiceobj;  //DEPENDENCY INJECTION

	//public Moduel1introductionApplication(@Qualifier("EMAILnotify") NotificationService notificationServiceobj) {
	//	this.notificationServiceobj = notificationServiceobj; // constructor DI
	//}

    @Autowired
    Map<String , NotificationService> notificationServiceMap = new HashMap<>();
	public static void main(String[] args) {

		SpringApplication.run(Moduel1introductionApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//notificationServiceobj.send("Hello World");
		for(var notificationService: notificationServiceMap.entrySet() ){
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("hello addy!!");
		}
	}

}
