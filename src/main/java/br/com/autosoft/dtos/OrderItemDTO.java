package br.com.autosoft.dtos;

import br.com.autosoft.entities.Order;
import br.com.autosoft.entities.OrderItem;
import br.com.autosoft.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDTO {
        
    private Integer id;
    private Integer quantity;
    private Double price;
    private Product product;
    private Order order;

    public OrderItemDTO(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.product = orderItem.getProduct();
        this.order = orderItem.getOrder();
    }
}
