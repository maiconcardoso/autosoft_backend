package br.com.autosoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.autosoft.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
