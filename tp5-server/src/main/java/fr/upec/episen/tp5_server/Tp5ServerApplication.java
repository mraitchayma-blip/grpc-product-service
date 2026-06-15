package fr.upec.episen.tp5_server;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp5ServerApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Tp5ServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Tp5ServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Initialization logic for the server
		logger.info("Initializing the grpc server");
	}
}
