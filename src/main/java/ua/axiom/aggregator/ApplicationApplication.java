package ua.axiom.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

//	todo fix logs - new file each time
//	todo password encoder
//	todo key delete
//	todo use Bootstrap inputs in .html
@SpringBootApplication
@PropertySource("classpath:/secret.properties")
public class ApplicationApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationApplication.class, args);
	}

}
