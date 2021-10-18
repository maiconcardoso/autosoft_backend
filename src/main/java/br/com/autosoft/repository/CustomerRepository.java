package br.com.autosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autosoft.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
