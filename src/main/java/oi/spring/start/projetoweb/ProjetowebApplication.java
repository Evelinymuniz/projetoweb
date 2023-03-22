package oi.spring.start.projetoweb;

import oi.spring.start.projetoweb.controller.TesteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetowebApplication {
	@Autowired
	private TesteController controller;
	public static void main(String[] args) {
		SpringApplication.run(ProjetowebApplication.class, args);
		System.out.println();
	}

}
