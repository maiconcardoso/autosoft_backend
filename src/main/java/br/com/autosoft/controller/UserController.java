package br.com.autosoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User create(@RequestBody User user){
		return userService.create(user);
	}
	
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> read() {
		List<UserDTO> result = userService.read();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> readBydId(@PathVariable Integer id) {
		Optional<UserDTO> result = userService.readById(id);
		if(result.isPresent()) {
			return new ResponseEntity<UserDTO>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
		
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody User alterUser) {
		Optional<UserDTO> result = userService.update(id, alterUser);
		if(result.isPresent()) {
			return new ResponseEntity<UserDTO>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDTO> delete(@PathVariable Integer id) {
		Optional<UserDTO> result = userService.delete(id);
		if(result.isPresent()) {
			return new ResponseEntity<UserDTO>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
