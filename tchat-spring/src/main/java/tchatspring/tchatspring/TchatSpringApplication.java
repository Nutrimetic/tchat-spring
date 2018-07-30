package tchatspring.tchatspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class TchatSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TchatSpringApplication.class, args);
	}
}
