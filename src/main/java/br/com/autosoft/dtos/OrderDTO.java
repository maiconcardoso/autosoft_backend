package br.com.autosoft.dtos;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.autosoft.entities.Customer;
import br.com.autosoft.entities.Order;
import br.com.autosoft.entities.OrderItem;
import br.com.autosoft.entities.OrderLabor;
import br.com.autosoft.enuns.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    private Integer id;
    private Calendar creationDate;
    private OrderStatus status;
    private Customer customer;  
    private List<OrderItem> items;
    private List<OrderLabor> labors; 
    private Double amount;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.creationDate = order.getCreationDate();
        this.status = order.getStatus();
        this.customer = order.getCustomer();
        this.items = order.getItems();
        this.labors = order.getLabors();
        this.amount = order.getTotal();
    }
}
