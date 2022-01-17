package br.com.autosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.autosoft.dtos.OrderLaborDTO;
import br.com.autosoft.entities.OrderLabor;
import br.com.autosoft.service.OrderLaborService;

@RestController
@RequestMapping("/order-labors")
public class OrderLaborController {
    
    @Autowired
    private OrderLaborService service;

    @GetMapping
    public ResponseEntity<List<OrderLaborDTO>> findAll() {
        List<OrderLaborDTO> orderLaborList = service.readAll();
        return ResponseEntity.status(HttpStatus.OK).body(orderLaborList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderLaborDTO> findById(@PathVariable Integer id) {
        OrderLaborDTO orderLaborById = service.readById(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderLaborById);
    }

    @PostMapping
    public ResponseEntity<OrderLaborDTO> save(@RequestBody OrderLabor orderLabor) {
        OrderLaborDTO orderLaborToBeSaved = service.create(orderLabor);
        return ResponseEntity.status(HttpStatus.OK).body(orderLaborToBeSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderLaborDTO> update(@PathVariable Integer id, @RequestBody OrderLabor orderLabor) {
        OrderLaborDTO orderLaborToBeUpdated = service.update(id, orderLabor);
        return ResponseEntity.status(HttpStatus.OK).body(orderLaborToBeUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
