package com.inforcol.infosalud;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfosaludApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(InfosaludApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InfosaludApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("La aplicación ha iniciado correctamente.");
		logger.debug("Ingresar a la documentación: http://localhost:8080/swagger-ui/index.html");
	}

	@PreDestroy
	public void onDestroy() {
		logger.info("La aplicación está a punto de cerrarse.");
	}
}
