package br.com.autosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.autosoft.dtos.OrderDTO;
import br.com.autosoft.entities.Order;
import br.com.autosoft.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> orderList = service.readAll();
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Integer id) {
        OrderDTO orderById = service.readById(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderById);
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order) {
        Order newOrder = service.save(order);
        return ResponseEntity.status(HttpStatus.OK).body(newOrder);
    }

    @PutMapping
    public ResponseEntity<OrderDTO> update(@RequestBody Order order, @PathVariable Integer id) {
        OrderDTO orderForUpdate = service.update(order, id);
        return ResponseEntity.status(HttpStatus.OK).body(orderForUpdate);
    }
}
