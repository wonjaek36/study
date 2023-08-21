package com.example.firstproject.service;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Slf4j
@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public ArrayList<Coffee> index() {
        return coffeeRepository.findAll();
    }

    public Coffee show(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Coffee create(CoffeeDto dto) {
        Coffee coffee = dto.toEntity();
        if (coffee.getId() != null) {
            return null;
        }
        return coffeeRepository.save(coffee);
    }

    @Transactional
    public Coffee update(Long id, CoffeeDto dto) {
        Coffee coffee = dto.toEntity();
        log.info("id: {}, coffee: {}", id, coffee.toString());

        Coffee target = coffeeRepository.findById(id).orElse(null);
        if (target == null || !id.equals(coffee.getId())) {
            log.info("URL id and coffee id are different!");
            return null;
        }

        target.patch(coffee);
        Coffee updated = coffeeRepository.save(target);
        return updated;
    }

    public Coffee delete(Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if (target == null) {
            log.info("No data exists");
            return null;
        }

        coffeeRepository.delete(target);
        return target;
    }
}
