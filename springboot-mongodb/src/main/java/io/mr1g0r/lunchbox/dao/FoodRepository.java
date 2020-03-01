package io.mr1g0r.lunchbox.dao;

import io.mr1g0r.lunchbox.model.FoodItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<FoodItem, String> {

}
