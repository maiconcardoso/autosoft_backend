package br.com.autosoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autosoft.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
    
}
