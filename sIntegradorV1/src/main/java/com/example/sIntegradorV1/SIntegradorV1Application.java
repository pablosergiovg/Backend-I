package com.example.sIntegradorV1;

import com.example.sIntegradorV1.dao.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SIntegradorV1Application {

	public static void main(String[] args) {
		BD.crearTablas();
		SpringApplication.run(SIntegradorV1Application.class, args);
	}

}
