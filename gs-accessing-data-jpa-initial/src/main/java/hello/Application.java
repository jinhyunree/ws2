package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String args[]){
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository){
		return(args) -> {
			
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));
			
			log.info("Customers found with findAll():");
			log.info("----------------------------------");
			for(Customer customer : repository.findAll()){
				log.info(customer.toString());
			}
			log.info("");
			
			Customer customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L)");
			log.info("----------------------------------");
			log.info(customer.toString());
			log.info("");
			
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("-----------------------------------------------");
			for(Customer bauner : repository.findByLastName("Bauer")){
				log.info(bauner.toString());
			}
			log.info("");
		};
	}
}
