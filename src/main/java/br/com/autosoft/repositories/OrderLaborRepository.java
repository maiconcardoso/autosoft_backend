package br.com.autosoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.autosoft.entities.OrderLabor;

@Repository
public interface OrderLaborRepository extends JpaRepository<OrderLabor, Integer>{
    
}
