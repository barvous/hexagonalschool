package br.com.grimoire.hexagonalschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HexagonalschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonalschoolApplication.class, args);
	}

}

//TODO: Create ports for the domain classes
//TODO: Create adapters for the domain classes
//TODO: Create endpoints to consume the domain entities