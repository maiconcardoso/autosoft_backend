package br.com.autosoft.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autosoft.dtos.CustomerDTO;
import br.com.autosoft.entities.Customer;
import br.com.autosoft.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<CustomerDTO> read() {
        List<Customer> registeredCustomer = repository.findAll();
        return registeredCustomer.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());
    } 
}
