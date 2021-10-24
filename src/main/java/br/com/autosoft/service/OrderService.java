package br.com.autosoft.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autosoft.dtos.OrderDTO;
import br.com.autosoft.entities.Order;
import br.com.autosoft.exceptions.EntityNotFoundException;
import br.com.autosoft.exceptions.NoSuchElementException;
import br.com.autosoft.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    public List<OrderDTO> readAll() {
        List<Order> orderList = repository.findAll();
        return orderList.stream().map(obj -> new OrderDTO(obj)).collect(Collectors.toList());
    }

    public OrderDTO readById(Integer id) {
        Optional<Order> orderById = repository.findById(id);
        return orderById.stream().map(obj -> new OrderDTO(obj)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException(EntityNotFoundException.MESSAGE));
    }

    public Order save(Order order) {
        return repository.save(order);
    }

    public OrderDTO update(Order order, Integer id) {
        Optional<Order> orderById = repository.findById(id);
        if (orderById.isPresent()) {
            Order orderForUpdate = orderById.get();
            orderForUpdate.setStatus(order.getStatus());
            orderForUpdate.setCreationDate(order.getCreationDate());
            orderForUpdate.setCustomer(order.getCustomer());
            repository.save(order);
        }
        return orderById.stream().map(obj -> new OrderDTO(obj)).findFirst()
                .orElseThrow(() -> new NoSuchElementException(NoSuchElementException.MESSAGE));
    }

}
