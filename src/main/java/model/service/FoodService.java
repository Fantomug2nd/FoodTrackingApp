package model.service;

import model.dao.api.DaoFactory;
import model.dao.api.concreteDao.FoodDao;
import model.dao.api.concreteDao.RecordDao;
import model.dao.jdbc.JdbcDaoFactory;
import model.entity.Food;
import model.entity.Record;
import model.entity.User;

import java.time.LocalDate;
import java.util.List;

public class FoodService {
    public List<Food> findAll() {
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            FoodDao foodDao = daoFactory.getFoodDao();
            return foodDao.findAll();
        }
    }

    public Food findById(int id) {
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            FoodDao foodDao = daoFactory.getFoodDao();
            return foodDao.findById(id).get();
        }
    }
}
