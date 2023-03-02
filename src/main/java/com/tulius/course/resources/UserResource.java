package com.tulius.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tulius.course.entities.User;
import com.tulius.course.service.UserService;
/*Informa que a classe é um recurso web que será implementado por um controlador “rest”.*/
@RestController
/*É preciso definir para o mapping um caminho, no caso "/users" .*/
@RequestMapping(value = "/users")
public class UserResource {
	
	
	//Inserindo dependêcia para o service.
	@Autowired
	private UserService service;
	//EndPoint findAll()
	//Método que retorna uma lista de usuários.
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/*EndPoint findById, porém será passado o valor do id do usuário.
	 * Como será retornado apenas um usuário o método será do tipo "User"*/
	@GetMapping(value = "/{id}")
	//PathVariable informa que o argumento será passado ao value acima
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj= service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
