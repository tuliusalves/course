package com.tulius.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tulius.course.entities.User;
/*Cria-se uma (interface) UserRepository, ele será responsável por fazer operações com entidade
 *  “User”.UserRepository precisa estender de JpaRepository, passando a entidade a ser acessada
 *   e o tipo da chave dentro de “<>” ,no caso a chave será do tipo “long”.*/

public interface UserRepository extends JpaRepository<User,Long> {
	
}
