package br.com.autosoft.dtos;

public class ClientDTO {
	
	private Integer id;
	private String name;
	private String whatsapp;
	private String fone;
	private String cpf;
	private String email;
	private String city;
	private String address;
	private String cep;
		
	public ClientDTO() {

	}
	
	public ClientDTO(String name, String whatsapp, String fone, String cpf, String email, String city, String address,
			String cep) {
		this.name = name;
		this.whatsapp = whatsapp;
		this.fone = fone;
		this.cpf = cpf;
		this.email = email;
		this.city = city;
		this.address = address;
		this.cep = cep;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
