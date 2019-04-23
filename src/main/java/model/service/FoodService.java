package model.service;

import model.dao.api.DaoFactory;
import model.dao.api.concreteDao.FoodDao;

import model.dao.jdbc.JdbcDaoFactory;
import model.entity.Food;



import java.util.List;
import java.util.Optional;

public class FoodService {
    public List<Food> findAll() {
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            FoodDao foodDao = daoFactory.getFoodDao();
            return foodDao.findAll();
        }
    }

    public Food findById(long id) {
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            FoodDao foodDao = daoFactory.getFoodDao();
            return foodDao.findById(id).get();
        }
    }

    public void insertFood(Food food){
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            FoodDao foodDao = daoFactory.getFoodDao();
            foodDao.create(food);
        }
    }

    public List<Food> findUserFood(long userId){
        try ( DaoFactory daoFactory = JdbcDaoFactory.getFactory()){
            FoodDao foodDao = daoFactory.getFoodDao();
            return foodDao.findByUserFood(userId);
        }
    }

    public boolean isFoodExist(String name, long weight, long userId){
        try (DaoFactory factory = JdbcDaoFactory.getFactory()) {
            FoodDao foodDao = factory.getFoodDao();
            Optional<Food> food = foodDao.findByNameAndWeight(name,weight,userId);
            return food.isPresent();
        }
    }
}
