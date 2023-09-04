package com.example.firstproject.service;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.entity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> index() {
        return pizzaRepository.findAll();
    }

    public Pizza show(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public Pizza create(PizzaDto pizzaDto) {
        Pizza pizza = pizzaDto.toEntity();
        if (pizza.getId() != null) {
            log.info("Not allowed predefined id for creation");
            return null;
        }
        return pizzaRepository.save(pizza);
    }

    public Pizza update(Long id, PizzaDto pizzaDto) {
        Pizza pizza = pizzaDto.toEntity();
        Pizza target = pizzaRepository.findById(id).orElse(null);
        log.info("id: {}, pizza: {}", id, pizza.toString());

        if (target == null || !pizza.getId().equals(id)) {
            log.info("URL id and coffee id are different!");
            return null;
        }
        target.patch(pizza);
        return pizzaRepository.save(target);
    }

    public Pizza delete(Long id) {
        Pizza target = pizzaRepository.findById(id).orElse(null);
        if (target == null) {
            log.info("No data exists");
            return null;
        }

        pizzaRepository.delete(target);
        return target;
    }
}
