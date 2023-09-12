package cl.miguelramos.pizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories // le indicamos que vamos a usar los repositories
public class PizzeriaApplication {

  public static void main(String[] args) {
    SpringApplication.run(PizzeriaApplication.class, args);
  }

}
