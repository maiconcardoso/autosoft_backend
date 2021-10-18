package br.com.autosoft.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import br.com.autosoft.entities.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "The id User cannot be Empty")
	private Integer id;
	@NotEmpty(message = "The Name User cannot be Empty")
	private String name;
	@NotEmpty(message = "The Nick Name User cannot be Empty")
	private String nick;
	@NotEmpty(message = "The Emal User cannot be Empty")
	private String email;
	
	public UserDTO() {}

	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.nick = user.getNick();
		this.email = user.getEmail();
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
