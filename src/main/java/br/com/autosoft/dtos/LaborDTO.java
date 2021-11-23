package br.com.autosoft.dtos;

import br.com.autosoft.entities.Labor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LaborDTO {

    private Integer id;
    private String description;
    private Double price;
    private String groupName;

    public LaborDTO(Labor labor) {
        this.id = labor.getId();
        this.description = labor.getDescription();
        this.price = labor.getPrice();
        this.groupName = labor.getGroupName();
    }
}
