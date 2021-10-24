package br.com.autosoft.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autosoft.dtos.OrderDTO;
import br.com.autosoft.entities.Order;
import br.com.autosoft.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public List<OrderDTO> readAll() {
        List<Order> orderList = repository.findAll();
        return orderList.stream()
            .map(obj -> new OrderDTO(obj)).collect(Collectors.toList());
    }

    public Order save(Order order) {
        return repository.save(order);
    }
  
}
