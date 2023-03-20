package com.tulius.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tulius.course.entities.Category;
import com.tulius.course.entities.Order;
import com.tulius.course.entities.User;
import com.tulius.course.entities.enums.OrderStatus;
import com.tulius.course.repositories.CategoryRepository;
import com.tulius.course.repositories.OrderRepository;
import com.tulius.course.repositories.UserRepository;
/*Agora será preciso fazer com que a classe “TestConfig” seja executada.
Para fazer isso será preciso implementar a interface “CommandLineRunner”. */


//Teste de push com STS
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//No final temos um atributo do tipo user sendo passado.
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITTING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITTING_PAYMENT, u1);
		
		/*Para salvar no BD. Usando o objeto userRepository utilize o método "saveAll"
		 * Passando como argumento o método asList. Ele pertence a classe Arrays que
		 * por sua vez passa um array de objetos. */
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}

}
