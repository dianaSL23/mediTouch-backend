package com.example.meditouch;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import Reminders.AppointmentsReminder;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.meditouch"})
public class MeditouchApplication {

	public static SimpMessagingTemplate messagingTemplate;

	public MeditouchApplication(SimpMessagingTemplate messagingTemplate) {
		MeditouchApplication.messagingTemplate = messagingTemplate;
	}

	public static void main(String[] args) throws SQLException, IOException {
		SpringApplication.run(MeditouchApplication.class, args);
		DatabaseConnection.getInstance().getMyCon();

		AppointmentsReminder reminder = new AppointmentsReminder(12 * 60 * 60, messagingTemplate);
	}

}
