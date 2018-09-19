package fr.wizard.fantasticBeasts.FantasticBeasts;

import fr.wizard.fantasticBeasts.DataBase.DataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FantasticBeastsApplication {

	public static void main(String[] args) {
		DataBase.load();
		SpringApplication.run(FantasticBeastsApplication.class, args);
	}


}
