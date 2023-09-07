package com.example.firstproject.api;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.service.PizzaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PizzaApiController {

    @Autowired
    private PizzaService pizzaService;

    // Get
    @GetMapping("/api/pizzas")
    public List<Pizza> index() {
        return pizzaService.index();
    }

    @GetMapping("/api/pizzas/{id}")
    public ResponseEntity<Pizza> show(@PathVariable Long id) {
         Pizza pizza = pizzaService.show(id);
         return pizza != null ?
                 ResponseEntity.status(HttpStatus.OK).body(pizza) :
                 ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Post
    @PostMapping("/api/pizzas")
    public ResponseEntity<Pizza> create(@RequestBody PizzaDto pizzaDto) {
        Pizza pizza = pizzaService.create(pizzaDto);
        return pizza != null ?
                ResponseEntity.status(HttpStatus.CREATED).body(pizza) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Patch
    @PatchMapping("/api/pizzas/{id}")
    public ResponseEntity<Pizza> patch(@PathVariable Long id, @RequestBody PizzaDto pizzaDto) {
        Pizza pizza = pizzaService.update(id, pizzaDto);
        return pizza != null ?
                ResponseEntity.status(HttpStatus.OK).body(pizza) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Delete
    @DeleteMapping("/api/pizzas/{id}")
    public ResponseEntity<Pizza> delete(@PathVariable Long id) {
        Pizza pizza = pizzaService.delete(id);
        return pizza != null ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
