package fr.wizard.fantasticBeasts.FantasticBeasts;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import fr.wizard.fantasticBeasts.DataBase.DataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableAdminServer
public class FantasticBeastsApplication {
	public static void main(String[] args) {
		DataBase.load();
		SpringApplication.run(FantasticBeastsApplication.class, args);
	}

	@Configuration
	public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().permitAll()
					.and().csrf().disable();
		}
	}
}
