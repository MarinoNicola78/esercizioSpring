package com.nicolamarino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringProcjectArticoloApplication {

	public static void main(String[] args) {
		
		String DB = "dbspringarticolo";
		
		SpringApplication.run(MySpringProcjectArticoloApplication.class, args);
		System.out.println("connected to DB: " + DB);
		System.out.println("###################################################");
		System.out.println("Starting App Gestione Articolo: MySpringProcjectArticoloApplication");
	}

}
