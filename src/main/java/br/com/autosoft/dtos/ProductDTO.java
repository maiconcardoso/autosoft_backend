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
    //private Provider provider;
    private String groupFamily;
    private String subGroup;
    private Double price;
    private String brand;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.factoryCode = product.getFactoryCode();
        //this.provider = product.getProvider();
        this.groupFamily = product.getGroupFamily();
        this.subGroup = product.getSubGroup();
        this.price = product.getPrice();
        this.brand = product.getBrand();
    }

}
