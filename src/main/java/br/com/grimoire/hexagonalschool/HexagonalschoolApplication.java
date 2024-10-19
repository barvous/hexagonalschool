package br.com.grimoire.hexagonalschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HexagonalschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalschoolApplication.class, args);
	}

}

/*
 * TODO: Create bussiness rules in JPA entities like:
 * 	- Duplicate entry error for Teachers with the same CPF
 * 	- Duplicate entry error for Students with the same CPF
 */
