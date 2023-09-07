package com.example.firstproject.dto;

import com.example.firstproject.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDto {

    private Long id;
    private String name;
    private Integer price;

    public Pizza toEntity() {
        return new Pizza(this.id, this.name, this.price);
    }
}
