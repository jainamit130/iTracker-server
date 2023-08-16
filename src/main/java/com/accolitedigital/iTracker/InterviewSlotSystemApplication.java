package com.accolitedigital.iTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.net.Socket;

@SpringBootApplication
@Profile("main")
public class InterviewSlotSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewSlotSystemApplication.class, args);
	}

	public static boolean hostAvailabilityCheck() {
		try (Socket s = new Socket("15-206-211-127", 8080)) {
			return true;
		} catch (IOException ex) {
			/* ignore */
		}
		return false;
	}
}
