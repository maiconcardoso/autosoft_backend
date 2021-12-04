package br.com.autosoft.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.autosoft.entities.Product;
import br.com.autosoft.entities.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    
    private Integer id;
    private String name;
    private String factoryCode;

    @JsonFormat
    private Provider provider;
    private String groupName;
    private Double price;
    private String brand;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.factoryCode = product.getFactoryCode();
        this.groupName = product.getGroupName();
        this.price = product.getPrice();
        this.brand = product.getBrand();
    }

}
