package com.tulius.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tulius.course.entities.User;
/*Informa que a classe é um recurso web que será implementado por um controlador “rest”.*/
@RestController
/*É preciso definir para o mapping um caminho, no caso "/users" .*/
@RequestMapping(value = "/users")
public class UserResource {
	
	/*Para testar o funcionamento, cria-se um método que serve como um "endPoint"
	 * para acessar "User" 
	 * 
	 * Seu retorno será um do tipo "ResponseEntity", método específico do String
	 * que serve para retornar respostas de requisições web.*/
	
	//GetMapping indica que um método equivale ao método "GET" do HTTP
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u= new User(1L,"Maria","maria@gmail.com","9999999","12345");
		/* "ok()" Retorna uma resposta com sucesso. ".body()" Retorna o corpo da resposta. */
		return ResponseEntity.ok().body(u);
	}
	
	

}
