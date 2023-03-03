package com.tulius.course.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tulius.course.entities.enums.OrderStatus;

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
	/*Para gegar o instante do pedido, o "Instant" é mais útil que o date
	 * Obs: formato (“ano-mês-dia ‘T’  hora:minuto:seg’Z’ ,  timezone= “padrão universal grenuwich”*/
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone= "GMT")
	private Instant moment;
	
	/*Criando atributo do enum. Integer para explicitar que será gravado no BD um número
	 * inteiro. Porém isso apenas existe internamente na classe "Order", para o externo
	 * o "orderStatus ainda está sendo mantido.*/
	private Integer orderStatus;
	/*Criando associações
	 * No caso um Order só tem um usuário que é o "client".*/
	@ManyToOne
	@JoinColumn(name= "client_id")
	private User client;
	
	public Order() {}
	
	public Order(Long id, Instant moment,OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		//Dessa vez, passaremos o set para setar diretamente os dados no construtor.
		setOrderStatus(orderStatus);
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

	
	public OrderStatus getOrderStatus() {
		//Para o get devemos passar o método estático de conversão do numérico
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		/*Já o set é preciso guardar internamente o número inteiro, nesse caso
		 * usa-se o "get.code()"
		 * Mas por precaução faça a checagem do "null"*/
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
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
