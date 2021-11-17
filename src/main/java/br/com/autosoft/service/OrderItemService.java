package br.com.autosoft.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autosoft.dtos.OrderItemDTO;
import br.com.autosoft.entities.OrderItem;
import br.com.autosoft.repositories.OrderItemRepository;

@Service
public class OrderItemService {
    
    @Autowired
    OrderItemRepository repository;


    public List<OrderItemDTO> readAll() {
        List<OrderItem> order = repository.findAll();
        return order.stream().map(obj -> new OrderItemDTO()).collect(Collectors.toList());
    }

    public OrderItem create(OrderItem orderItem) {
        OrderItem orderForSaved = repository.save(orderItem);
        return orderForSaved;
    }
}
