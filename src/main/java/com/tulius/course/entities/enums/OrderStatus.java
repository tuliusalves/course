package com.tulius.course.entities.enums;

public enum OrderStatus {
	
	WAITTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	/*Seria possível já ir inserindo os valores da enum, porém por padrão mesmo que
	 *  elas tenham os seus nomes, o java iria adicionar valores associados a cada um.
		Então um “WAITTING_PAYMENT” seria um “0”, na hora de salvar no BD.
		Se alguma constante for adicionada posteriormente, dependendo da posição teremos
		uma alteração em relação aos valores das constantes. E isso pode ser um problema 
		de manutenção no futuro.Por isso é preciso inserir manualmente os valores das constantes.
		Para evitar isso, cria-se um atributo inteiro e depois um construtor para o tipo enumerado
		 contendo um número inteiro.
*/
	
	private int code;
	
	private OrderStatus(int code) {
		this.code=code;
	}
	/*Para que o int "code" fique acessível ao exterior cria-se um método público para acessá-lo*/
	public int getCode() {
		return code;
	}
	/*Agora cria-se um método estático para conversão do valor numério em um enum
	 * Ou seja, ao passar um numero, teremos um inteiro correspondente.*/ 
	public static OrderStatus valueOf(int code) {
		//for each do value(enum auxiliar) varrendo os valores de OrderStatus
		for(OrderStatus value: OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
			// Caso não haja o código, lance uma excessão do tipo IllegalArgumentException
		} throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
