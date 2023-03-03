package com.tulius.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tulius.course.entities.Category;
import com.tulius.course.service.CategoryService;
/*Informa que a classe é um recurso web que será implementado por um controlador “rest”.*/
@RestController
/*É preciso definir para o mapping um caminho, no caso "/Categorys" .*/
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	
	//Inserindo dependêcia para o service.
	@Autowired
	private CategoryService service;
	//EndPoint findAll()
	//Método que retorna uma lista de usuários.
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	/*EndPoint findById, porém será passado o valor do id do usuário.
	 * Como será retornado apenas um usuário o método será do tipo "Category"*/
	@GetMapping(value = "/{id}")
	//PathVariable informa que o argumento será passado ao value acima
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj= service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
