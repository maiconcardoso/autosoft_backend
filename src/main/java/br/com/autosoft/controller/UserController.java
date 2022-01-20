package br.com.autosoft.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.autosoft.dtos.UserDTO;
import br.com.autosoft.entities.User;
import br.com.autosoft.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1")
public class UserController {
	// localhost:8080/v1/auth/users

	@Autowired
	private UserService userService;

	@PostMapping("/auth/users")
	public ResponseEntity<User> create(@RequestBody @Valid User user) {
		userService.create(user);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/auth/users")
	public ResponseEntity<List<UserDTO>> read() {
		List<UserDTO> users = userService.read();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/auth/users/{id}")
	public ResponseEntity<UserDTO> readBydId(@PathVariable Integer id) {
		UserDTO userById = userService.readById(id);
		return ResponseEntity.status(HttpStatus.OK).body(userById);

	}

	@PutMapping("/auth/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody User alterUser) {
		UserDTO userForUpdate = userService.update(id, alterUser);
		return ResponseEntity.status(HttpStatus.OK).body(userForUpdate);
	}

	@DeleteMapping("/auth/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UserDTO> delete(@PathVariable Integer id) {
		UserDTO userForDelete = userService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(userForDelete);
	}

}
