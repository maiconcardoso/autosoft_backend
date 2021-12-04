package br.com.autosoft.dtos;

import br.com.autosoft.entities.OrderItem;
import br.com.autosoft.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDTO {
    
    private Integer quantity;
    private Product product;
    private Double subTotal;

    public OrderItemDTO(OrderItem orderItem) {
        this.quantity = orderItem.getQuantity();
        this.product = orderItem.getProduct();
        this.subTotal = orderItem.getSubTotal();
    }
}
