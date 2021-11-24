package br.com.autosoft.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_order_labor")
public class OrderLabor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "labor_id")
    private Labor labor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public double getTotalLabor() {
        return quantity * price;
    }

    public OrderLabor(Integer id, Integer quantity, Double price, Labor labor) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.labor = labor;
    }
}
