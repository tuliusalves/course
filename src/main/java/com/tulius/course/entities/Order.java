package com.tulius.course.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
/*Order é um nome reservado em java, então precisamos renomear
 *Para manter o padrão, renomei user para "tb_user"*/
@Table(name ="tb_order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//Para gegar o instante do pedido, o "Instant" é mais útil que o date
	private Instant moment;
	/*Criando associações
	 * No caso um Order só tem um usuário que é o "client". Logo, a relação
	 * é, "vários para um", representado pela anotação @ManyToOne.
	 * relacionamento entre Order e client. Para que o jpa faça a transformação 
	 * em chave estrangeira no BD. @JoinColumn é a anotação que indica o nome
	 * da chave estrangeira no Bd.*/
	@ManyToOne
	@JoinColumn(name= "client_id")
	private User client;
	
	public Order() {}

	public Order(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
