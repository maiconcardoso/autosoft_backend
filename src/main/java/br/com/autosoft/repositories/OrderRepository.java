package br.com.autosoft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.autosoft.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT obj FROM Order obj WHERE obj.customer.name LIKE :name ORDER BY obj.creationDate desc")
    List<Order> findByCustomerName(String name);   

}
