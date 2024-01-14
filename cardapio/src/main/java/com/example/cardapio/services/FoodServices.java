package com.example.cardapio.services;

import com.example.cardapio.dto.FoodRequestDTO;
import com.example.cardapio.dto.FoodResponseDTO;
import com.example.cardapio.model.Food;
import com.example.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServices {

    @Autowired
    private FoodRepository repository;

    public List<FoodResponseDTO> getAll() {
        List<Food> foods = repository.findAll();
        return foods.stream()
                .map(f -> new FoodResponseDTO(f.getId(),
                        f.getTitle(),
                        f.getImage(),
                        f.getPrice()))
                .collect(Collectors.toList());
    }

    public void saveFood(FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
    }
}
