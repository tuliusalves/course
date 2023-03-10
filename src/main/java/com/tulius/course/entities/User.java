package com.tulius.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/*Quando passamos de POO para relacional, é preciso guiar-se pela especificação
 * ao invés da implementação. Por isso usa-se o jarkata.persistence*/

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	
	// Número de série padrão do serializable
	private static final long serialVersionUID = 1L;
	//Use "long" para representar id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	/*Criando associações
	 *Com precisamos instanciar as coleções, orders já deve ser
	 *instanciado com ArrayList
	 *No caso de coleção, apenas será preciso adicionar o método get. 
	 *Pois penas será apenas acrescentado ou removido. 
	 *Não será preciso trocar a lista 
	 *
	 *A associação paralela deve ser feita nessa lista usando @OneToMany, 
	 *porém deve ser mapeado dentro do parênteses o nome do atributo que
	 *está do outro lado da associação, no caso o “client” de User.*/
	
	/*Para evitar o erro de loop de "jackson" um dos lados da dependência
	 * deve ter o @JsonIgnore*/
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	//Ao trabalhar com frameworks, deve-se criar um construtor vazio.
	public User() {}

	public User(Long id, String name, String email, String phone, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
	
}
