package com.tulius.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulius.course.entities.Order;
import com.tulius.course.repositories.OrderRepository;
/*Component Registrantion
Todo objeto que pode ser injetado pela injeção de dependência.
A classe desse objeto precisa estar devidamente registrada.
Isso é feito através da anotação “@Component”. Porém esse comando pode variar
 de acordo com a necessidade. Se temos um repositório então será usado “@Repository”.
  Um serviço “@Service”.
*/

@Service
public class OrderService {
	/*Para executar operações OrderService precisa de uma dependência de “OrderRepository”*/
	@Autowired
	private OrderRepository repository;
	
	/*Método que retorna todos os Orders do bd*/
	public List<Order> findAll(){
		//Repassando a chamada para o objeto de OrderRepository
		return repository.findAll();
	}
	
	/*Método buscando usuário por ID */
	public Order findById(Long id) {
		/*Retornando um objeto Optional*/
		Optional<Order> obj = repository.findById(id);
		/*A operação get() irá retornar um objeto dentro de <> */
		return obj.get();
	}
}
