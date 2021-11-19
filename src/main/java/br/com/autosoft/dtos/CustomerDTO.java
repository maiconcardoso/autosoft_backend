package br.com.autosoft.dtos;

import javax.validation.constraints.NotEmpty;

import br.com.autosoft.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDTO {
	
	private Integer id;

	@NotEmpty(message = "The name Customer cannot be empty")
	private String name;
	
	@NotEmpty(message = "The Fone Customer cannot be empty")
	private String fone;
	private String cpf;
	private String email;
	private String city;
	private String address;
	private String cep;
	
	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.fone = customer.getFone();
		this.cpf = customer.getCpf();
		this.email = customer.getEmail();
		this.city = customer.getCity();
		this.address = customer.getAddress();
		this.cep = customer.getCep();
	}
}
