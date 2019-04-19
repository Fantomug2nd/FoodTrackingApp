package model.dao.jdbc;

import model.dao.api.DaoFactory;
import model.dao.api.concreteDao.RecordDao;
import model.dao.api.concreteDao.FoodDao;
import model.dao.api.concreteDao.UserDao;
import model.dao.jdbc.concreteDao.JdbcFoodDao;
import model.dao.jdbc.concreteDao.JdbcRecordDao;
import model.dao.jdbc.concreteDao.JdbcUserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDaoFactory implements DaoFactory {
    private Connection connection;
    private UserDao userDao;
    private RecordDao recordDao;
    private FoodDao foodDao;


    public JdbcDaoFactory(Connection connection) {
        this.connection = connection;
    }

    private static Connection getConnectionFromPool() {
        try {
            DataSource ds = ConnectionPoolHolder.getDataSource();
            return ds.getConnection();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public static DaoFactory getFactory() {
        return new JdbcDaoFactory(getConnectionFromPool());
    }

    @Override
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new JdbcUserDao(getCurrentConnection());
        }
        return userDao;
    }

    @Override
    public FoodDao getFoodDao() {
        if (foodDao == null) {
            foodDao = new JdbcFoodDao(getCurrentConnection());
        }
        return foodDao;
    }

    private Connection getCurrentConnection() {
        if (connection == null) {
            connection = getConnectionFromPool();
        }
        return connection;
    }

    @Override
    public RecordDao getRecordDao() {
        if (recordDao == null) {
            recordDao = new JdbcRecordDao(
                    getCurrentConnection(),
                    getUserDao(),
                    getFoodDao());
        }
        return recordDao;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
