package br.com.autosoft.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "creation_date")
    private Calendar creationDate;
    private OrderStatus status;

    @OneToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;   
    
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items = new ArrayList<>();
    private Double amount;

    public double getTotal() {
        amount = 0.0;
        for (OrderItem item : items) { amount += item.getSubTotal(); }
        return amount;
    }

}
