package io.mr1g0r.lunchbox.service;

import io.mr1g0r.lunchbox.model.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.sql.Struct;
import java.util.List;

@RestController
public class LunchboxController {

    @Autowired
    private LunchboxService lunchboxService;

    @GetMapping("/list")
    public List<FoodItem> getLunchboxContent(Model model) {
        return lunchboxService.getLunchboxContent();
    }

    @GetMapping("/{id}")
    public String getFoodItem(@PathVariable String id, Model model) {
        FoodItem foodItem = lunchboxService.getFoodItem(id);
        model.addAttribute("name", foodItem.getName());
        model.addAttribute("description", foodItem.getDescription());
        return "";
    }

    @PostMapping("/add")
    public ResponseEntity<FoodItem> add(@RequestBody FoodItem foodItem) throws IOException {
        FoodItem createdFoodItem = lunchboxService.addFoodItem(foodItem.getName(), foodItem.getDescription());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(createdFoodItem.getId()).toUri();

        return ResponseEntity.created(uri).body(createdFoodItem);
    }
}
