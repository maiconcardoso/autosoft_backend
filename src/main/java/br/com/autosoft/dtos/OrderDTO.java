package br.com.autosoft.dtos;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.autosoft.entities.Customer;
import br.com.autosoft.entities.Order;
import br.com.autosoft.entities.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Calendar creationDate;
    private OrderStatus status;
    private Customer customer;   
    private Double amount;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.creationDate = order.getCreationDate();
        this.status = order.getStatus();
        this.customer = order.getCustomer();
        this.amount = order.getTotal();
    }
}
