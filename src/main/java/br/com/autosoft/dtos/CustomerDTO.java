package br.com.autosoft.dtos;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.autosoft.entities.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CustomerDTO {
	
	private Integer id;
	@NotEmpty(message = "The name Customer cannot be empty")
	private String name;
	@NotEmpty(message = "The Fone Customer cannot be empty")
	private String fone;
	@NotEmpty(message = "The Cpf Customer cannot be empty")
	private String cpf;
	@NotEmpty(message = "The Email Customer cannot be empty")
	private String email;
	@NotEmpty(message = "The City Customer cannot be empty")
	private String city;
	@NotEmpty(message = "The Address Customer cannot be empty")
	private String address;
	@NotEmpty(message = "The Cep Customer canoot be empyt")
	private String cep;
	
	public CustomerDTO(Customer customer) {
		this.name = customer.getName();
		this.fone = customer.getFone();
		this.cpf = customer.getCpf();
		this.email = customer.getEmail();
		this.city = customer.getCity();
		this.address = customer.getAddress();
		this.cep = customer.getCep();
	}
}
