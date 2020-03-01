package io.mr1g0r.lunchbox.service;

import io.mr1g0r.lunchbox.dao.FoodRepository;
import io.mr1g0r.lunchbox.model.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LunchboxService {

    @Autowired
    private FoodRepository foodRepository;

    public List<FoodItem> getLunchboxContent() {
        return foodRepository.findAll();
    }

    public FoodItem addFoodItem(String name, String description) throws IOException {
        FoodItem foodItem = new FoodItem(name, description);
        foodItem = foodRepository.insert(foodItem);
        return foodItem;
    }

    public FoodItem getFoodItem(String id) {
        return foodRepository.findById(id).get();
    }
}
