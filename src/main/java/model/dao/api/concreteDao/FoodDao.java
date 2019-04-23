package model.dao.api.concreteDao;

import model.dao.api.GenericDao;
import model.entity.Food;

import java.util.List;
import java.util.Optional;

public interface FoodDao extends GenericDao<Food> {
    public List<Food> findByUserFood(long userId);
    public Optional<Food> findByNameAndWeight(String name, long weight,long userId);

}
