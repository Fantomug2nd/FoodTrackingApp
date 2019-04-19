package model.dao.api;

import model.dao.api.concreteDao.RecordDao;
import model.dao.api.concreteDao.UserDao;
import model.dao.api.concreteDao.FoodDao;

public interface DaoFactory extends AutoCloseable {
    UserDao getUserDao();

    RecordDao getRecordDao();

    FoodDao getFoodDao();

    void close();
}
