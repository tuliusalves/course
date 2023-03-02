package com.tulius.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulius.course.entities.User;
import com.tulius.course.repositories.UserRepository;
/*Component Registrantion
Todo objeto que pode ser injetado pela injeção de dependência.
A classe desse objeto precisa estar devidamente registrada.
Isso é feito através da anotação “@Component”. Porém esse comando pode variar
 de acordo com a necessidade. Se temos um repositório então será usado “@Repository”.
  Um serviço “@Service”.
*/

@Service
public class UserService {
	/*Para executar operações UserService precisa de uma dependência de “UserRepository”*/
	@Autowired
	private UserRepository repository;
	
	/*Método que retorna todos os users do bd*/
	public List<User> findAll(){
		//Repassando a chamada para o objeto de UserRepository
		return repository.findAll();
	}
	
	/*Método buscando usuário por ID */
	public User findById(Long id) {
		/*Retornando um objeto Optional*/
		Optional<User> obj = repository.findById(id);
		/*A operação get() irá retornar um objeto dentro de <> */
		return obj.get();
	}
}
