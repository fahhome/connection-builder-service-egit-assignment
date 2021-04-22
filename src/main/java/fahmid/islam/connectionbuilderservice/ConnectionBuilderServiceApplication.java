package fahmid.islam.connectionbuilderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionBuilderServiceApplication {

	public static void main(String[] args) {
		System.out.println("Connection builder Service - check connecting flights");
		SpringApplication.run(ConnectionBuilderServiceApplication.class, args);
	}

}
