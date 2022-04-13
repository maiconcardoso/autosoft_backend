package br.com.autosoft.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.autosoft.dtos.OrderItemDTO;
import br.com.autosoft.entities.OrderItem;
import br.com.autosoft.service.OrderItemService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("v1/auth/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> findById(@PathVariable Integer id) {
        OrderItemDTO orderItemById = service.readById(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderItemById);
    }

    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> findAll() {
        List<OrderItemDTO> orders = service.readAll();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping
    public ResponseEntity<OrderItemDTO> save(@RequestBody OrderItem orderItem,
            @RequestParam(value = "order", defaultValue = "0") Integer id_order) {
        OrderItemDTO orderItemSaved = service.create(orderItem, id_order);
        return ResponseEntity.status(HttpStatus.OK).body(orderItemSaved);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OrderItemDTO> update(@PathVariable Integer id, @RequestBody OrderItem orderItem) {
        OrderItemDTO orderItemUpdated = service.update(id, orderItem);
        return ResponseEntity.status(HttpStatus.OK).body(orderItemUpdated);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
