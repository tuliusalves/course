package com.tulius.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulius.course.entities.Category;
import com.tulius.course.repositories.CategoryRepository;
/*Component Registrantion
Todo objeto que pode ser injetado pela injeção de dependência.
A classe desse objeto precisa estar devidamente registrada.
Isso é feito através da anotação “@Component”. Porém esse comando pode variar
 de acordo com a necessidade. Se temos um repositório então será usado “@Repository”.
  Um serviço “@Service”.
*/

@Service
public class CategoryService {
	/*Para executar operações CategoryService precisa de uma dependência de “CategoryRepository”*/
	@Autowired
	private CategoryRepository repository;
	
	/*Método que retorna todos os Categorys do bd*/
	public List<Category> findAll(){
		//Repassando a chamada para o objeto de CategoryRepository
		return repository.findAll();
	}
	
	/*Método buscando usuário por ID */
	public Category findById(Long id) {
		/*Retornando um objeto Optional*/
		Optional<Category> obj = repository.findById(id);
		/*A operação get() irá retornar um objeto dentro de <> */
		return obj.get();
	}
}
