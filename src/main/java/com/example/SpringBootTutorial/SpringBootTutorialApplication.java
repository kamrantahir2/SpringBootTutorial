package com.example.SpringBootTutorial;
// This is the base Application class that was included in the SpringBoot Initializr

// ABOUT
// -------

// - Take photos and upload them to the server
// - Take photos, read them, update then and delete them CRUD

// Photo Requirements:
	// - ID
	// - Filename
	// - Image Data


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

}
