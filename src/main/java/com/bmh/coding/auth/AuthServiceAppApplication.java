package com.bmh.coding.auth;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bmh.coding.auth.model.ClientApi;
import com.bmh.coding.auth.repository.ClientApiRepository;

/**
 * @author Mohamed Babchia
 *
 */

@SpringBootApplication
public class AuthServiceAppApplication {

	/**
	 * initial same data 
	 * @param clientApiRepository
	 * @return
	 */
	@Bean
	CommandLineRunner Demo(ClientApiRepository clientApiRepository) {
		return args -> {

			Stream.of("clientapi1,firstpass", "clientapi2,secondePass", "clientapi3,thirdPass").map(x -> x.split(","))
					.forEach(x -> clientApiRepository.save(new ClientApi(x[0], x[1], true)));

		};

	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceAppApplication.class, args);
	}
}
