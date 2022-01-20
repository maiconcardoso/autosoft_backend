package br.com.autosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.autosoft.dtos.CustomerDTO;
import br.com.autosoft.entities.Customer;
import br.com.autosoft.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService service;
    
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        List<CustomerDTO> registeredCustomer = service.readAll();
        return ResponseEntity.status(HttpStatus.OK).body(registeredCustomer);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Customer>> findPageable(Pageable page) {
        Page<Customer> customerPage = service.readPageable(page);
        return ResponseEntity.status(HttpStatus.OK).body(customerPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Integer id) {
        CustomerDTO customerFound = service.readById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customerFound);
    }

    @GetMapping("/find")
    public ResponseEntity<List<CustomerDTO>> findByName(@RequestParam String name) {
        List<CustomerDTO> customerNameFound = service.readByName(name);
        if(customerNameFound.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(customerNameFound);
        return ResponseEntity.status(HttpStatus.OK).body(customerNameFound); 
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customerToBeSaved) {
        Customer customerSave = service.save(customerToBeSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@RequestBody Customer customerToBeUpdated, @PathVariable Integer id) {
        CustomerDTO customerUpdate = service.update(customerToBeUpdated, id);
        return ResponseEntity.status(HttpStatus.OK).body(customerUpdate);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
