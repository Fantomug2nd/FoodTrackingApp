package model.dao.jdbc.concreteDao;

import model.dao.api.concreteDao.FoodDao;
import model.dao.jdbc.JdbcGenericDao;
import model.entity.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcFoodDao extends JdbcGenericDao<Food> implements FoodDao {

    private static final String FIND_ALL_QUERY = "SELECT food_id, name, carbs, fat, protein, calories, weight FROM food";
    private static final String INSERT_QUERY = "INSERT INTO food( name, carbs, fat, protein, calories, weight ) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT food_id, name, carbs, fat, protein, calories, weight FROM food WHERE food_id=?";

    public JdbcFoodDao(Connection connection) {
        super(connection);
    }

    @Override
    protected void setUpdateQueryParams(PreparedStatement s, Food entity) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getUpdateQuery() {
        throw new UnsupportedOperationException();

    }

    @Override
    protected String getInsertQuery() {
        return INSERT_QUERY;
    }

    @Override
    protected void setInsertQueryParams(PreparedStatement s, Food food) throws SQLException {
        setFoodParams(s, food);
    }


    private void setFoodParams(PreparedStatement s, Food food) throws SQLException {
        s.setString(1, food.getName());
        s.setInt(2, food.getCarbs());
        s.setInt(3, food.getFat());
        s.setInt(4, food.getProtein());
        s.setInt(5, food.getCalories());
        s.setInt(6, food.getWeight());
    }

    @Override
    protected Food getFromResultSet(ResultSet resultSet) throws SQLException {
        Food food = new Food();
        food.setId(resultSet.getInt("food_id"));
        food.setName(resultSet.getString("name"));
        food.setCarbs(resultSet.getInt("carbs"));
        food.setFat(resultSet.getInt("fat"));
        food.setProtein(resultSet.getInt("protein"));
        food.setCalories(resultSet.getInt("calories"));
        food.setWeight(resultSet.getInt("weight"));
        return food;
    }

    @Override
    protected void setFindByIdQueryParams(PreparedStatement s, int id) throws SQLException {
        s.setInt(1, id);
    }

    @Override
    protected String getFindByIdQuery() {
        return FIND_BY_ID_QUERY;
    }

    @Override
    protected String getFindAllQuery() {
        return FIND_ALL_QUERY;
    }
}
