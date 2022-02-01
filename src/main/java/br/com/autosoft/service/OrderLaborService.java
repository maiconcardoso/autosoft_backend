package br.com.autosoft.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autosoft.dtos.OrderLaborDTO;
import br.com.autosoft.entities.OrderLabor;
import br.com.autosoft.exceptions.EntityNotFoundException;
import br.com.autosoft.repositories.OrderLaborRepository;

@Service
public class OrderLaborService {

    @Autowired
    private OrderLaborRepository repository;

    public List<OrderLaborDTO> readAll() {
        List<OrderLabor> orderLaborList = repository.findAll();
        return orderLaborList.stream().map((obj) -> new OrderLaborDTO(obj)).collect(Collectors.toList());
    }

    public OrderLaborDTO readById(Integer id) {
        Optional<OrderLabor> orderLaborById = repository.findById(id);
        return orderLaborById.stream().map((obj) -> new OrderLaborDTO(obj)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException(EntityNotFoundException.MESSAGE));
    }

    public OrderLaborDTO create(OrderLabor orderLabor) {
        OrderLabor orderLaborToBeSaved = repository.save(orderLabor);
        OrderLaborDTO orderLaborSaved = new OrderLaborDTO(orderLaborToBeSaved);
        return orderLaborSaved;
    }

    public OrderLaborDTO update(Integer id, OrderLabor orderLabor) {
        Optional<OrderLabor> orderLaborById = repository.findById(id);
        if (orderLaborById.isPresent()) {
            OrderLabor orderLaborUpdate = orderLaborById.get();
            orderLaborUpdate.setId(orderLabor.getId());
            orderLaborUpdate.setLabor(orderLabor.getLabor());
            orderLaborUpdate.setOrder(orderLabor.getOrder());
            orderLaborUpdate.setSubTotal(orderLabor.getSubTotal());
            orderLaborUpdate.setQuantity(orderLabor.getQuantity());
            repository.save(orderLaborUpdate);
        }
        return orderLaborById.stream().map((obj) -> new OrderLaborDTO(obj)).findFirst()
                .orElseThrow(() -> new EntityNotFoundException(EntityNotFoundException.MESSAGE));
    }

    public void delete(Integer id) {
        readById(id);
        repository.deleteById(id);
    }

}
