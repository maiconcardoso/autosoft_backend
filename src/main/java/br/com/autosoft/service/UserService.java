package br.com.autosoft.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autosoft.dtos.UserDTO;
import br.com.autosoft.entities.User;
import br.com.autosoft.exceptions.EntityNotFoundException;
import br.com.autosoft.exceptions.NoSuchElementException;
import br.com.autosoft.exceptions.RegisteredEntityException;
import br.com.autosoft.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User create(User userForCreate){
		User newUser = repository.findByEmail(userForCreate.getEmail());
		if (newUser == null) {
			return repository.save(userForCreate);
		}
		throw new RegisteredEntityException(RegisteredEntityException.MESSAGE);
	}

	public List<UserDTO> read() {
		List<User> user = repository.findAll();
		return user.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
	}

	public UserDTO readById(Integer id) {
		Optional<User> userById = repository.findById(id);
		return userById.stream().map(obj -> new UserDTO(obj)).findFirst()
				.orElseThrow(() -> new EntityNotFoundException(EntityNotFoundException.MESSAGE));
	}

	public UserDTO update(Integer id, User alterUser) {
		Optional<User> userForUpdate = repository.findById(id);
		if (userForUpdate.isPresent()) {
			User user = userForUpdate.get();
			user.setUsername(alterUser.getUsername());
			user.setEmail(alterUser.getEmail());
			repository.save(alterUser);
		}
		return userForUpdate.stream().map(obj -> new UserDTO(obj)).findFirst()
				.orElseThrow(() -> new NoSuchElementException(NoSuchElementException.MESSAGE));
	}

	public UserDTO delete(Integer id) {
		Optional<User> userForDelete = repository.findById(id);
		if (userForDelete.isPresent())
			repository.delete(userForDelete.get());
		return userForDelete.stream().map(obj -> new UserDTO(obj)).findFirst()
				.orElseThrow(() -> new NoSuchElementException(NoSuchElementException.MESSAGE));
	}

}
