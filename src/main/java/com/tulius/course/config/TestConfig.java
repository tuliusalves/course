package com.tulius.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tulius.course.entities.User;
import com.tulius.course.repositories.UserRepository;
/*Agora será preciso fazer com que a classe “TestConfig” seja executada.
Para fazer isso será preciso implementar a interface “CommandLineRunner”. */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository ;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		/*Para salvar no BD. Usando o objeto userRepository utilize o método "saveAll"
		 * Passando como argumento o método asList. Ele pertence a classe Arrays que
		 * por sua vez passa um array de objetos. */
		userRepository.saveAll(Arrays.asList(u1,u2));
	}

}
