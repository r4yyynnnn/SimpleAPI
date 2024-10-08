package Simple.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"Simple.API", "Simple.API.config", "Simple.API.controller", "Simple.API.service"})
@EnableJpaRepositories(basePackages = "Simple.API.repo")
@EntityScan(basePackages = "Simple.API.entity")
public class ApiMain {

	public static void main(String[] args) {
		SpringApplication.run(ApiMain.class, args);
	}

}
