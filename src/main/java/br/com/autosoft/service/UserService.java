package br.com.autosoft.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.autosoft.dtos.UserDTO;
import br.com.autosoft.entities.User;
import br.com.autosoft.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	public List<UserDTO> read() {
		List<User> result = userRepository.findAll();
		return result.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	public Optional<UserDTO> readById(@PathVariable Integer id) {
		Optional<User> result = userRepository.findById(id);
		return result.stream().map(x -> new UserDTO(x)).findFirst();
	}
	
	public Optional<UserDTO> update(@PathVariable Integer id, @RequestBody User alterUser) {
		Optional<User> result = userRepository.findById(id);
	    User user = result.get();
		user.setName(alterUser.getName());
		user.setNick(alterUser.getNick());
		user.setEmail(alterUser.getEmail());
		userRepository.save(alterUser);
		return result.stream().map(x -> new UserDTO(x)).findFirst();
	}
	
	public Optional<UserDTO> delete(@PathVariable Integer id) {
		Optional<User> result = userRepository.findById(id);
		userRepository.delete(result.get());
		return result.stream().map(x -> new UserDTO(x)).findFirst();
	}
	

}
