package com.example.demo;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "world") String name){
		return "Hello " + name;
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository){
		return args -> {
			repository.save(new Customer("leo", "aa"));
//			repository.save(new Customer("you", "ab"));
//			repository.save(new Customer("jun", "ac"));
//			repository.save(new Customer("leoo", "aa"));
			for(Customer customer : repository.findAll())
				log.info(customer.toString());


			log.info("");
			log.info("findById----------");
			Customer customer = repository.findById(1L);
			log.info(customer.toString());
			log.info("");

			log.info("findById----------");
			repository.findByLastName("aa").forEach(c -> {log.info(c.toString()); });
			log.info("");

		};
	}
}
