package br.com.autosoft.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.autosoft.entities.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "The id User cannot be Empty")
	private Integer id;
	@NotEmpty(message = "The Name User cannot be Empty")
	private String username;
	@NotEmpty(message = "The Emal User cannot be Empty")
	private String email;
	
	public UserDTO() {}

	public UserDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
