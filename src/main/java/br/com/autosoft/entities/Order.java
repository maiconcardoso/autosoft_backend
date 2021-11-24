package br.com.autosoft.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.autosoft.enuns.OrderStatus;
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
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLabor> labors = new ArrayList<>();

    private Double amount;

    public double getTotal() {
        double totalItems = 0.0;
        double totalLabors = 0.0;
        amount = 0.0;
        for (OrderItem item : items) { totalItems += item.getSubTotal(); }
        for (OrderLabor labor : labors ) { totalLabors += labor.getTotalLabor(); }
        amount = totalItems + totalLabors;
        return amount;
    }
}
