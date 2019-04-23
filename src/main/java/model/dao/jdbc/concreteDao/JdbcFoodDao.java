package model.dao.jdbc.concreteDao;

import model.dao.api.concreteDao.FoodDao;
import model.dao.jdbc.JdbcGenericDao;
import model.entity.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class JdbcFoodDao extends JdbcGenericDao<Food> implements FoodDao {

    private static final String FIND_ALL_QUERY = "SELECT food_id, name, carbs, fat, protein, calories,user_id, weight FROM food ";
    private static final String FIND_USER_FOOD_QUERY = "SELECT food_id, name, carbs, fat, protein, calories,user_id, weight FROM food WHERE user_id IS NULL OR user_id = ?";
    private static final String FIND_BY_NAME_AND_WEIGHT_QUERY = "SELECT food_id, name, carbs, fat, protein, calories, user_id, weight FROM food WHERE (user_id IS NULL OR user_id = ?) " +
            "AND name=? AND weight=?";
    private static final String INSERT_QUERY = "INSERT INTO food( name, carbs, fat, protein, calories,user_id, weight ) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT food_id, name, carbs, fat, protein, calories,user_id, weight FROM food WHERE food_id=?";

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
        s.setLong(2, food.getCarbs());
        s.setLong(3, food.getFat());
        s.setLong(4, food.getProtein());
        s.setLong(5, food.getCalories());
        s.setLong(6, food.getUserId());
        s.setLong(7, food.getWeight());

    }

    @Override
    protected Food getFromResultSet(ResultSet resultSet) throws SQLException {
        Food food = new Food();
        food.setId(resultSet.getLong("food_id"));
        food.setName(resultSet.getString("name"));
        food.setCarbs(resultSet.getLong("carbs"));
        food.setFat(resultSet.getLong("fat"));
        food.setProtein(resultSet.getLong("protein"));
        food.setCalories(resultSet.getLong("calories"));
        food.setUserId(resultSet.getLong("user_id"));
        food.setWeight(resultSet.getLong("weight"));
        return food;
    }

    @Override
    protected void setFindByIdQueryParams(PreparedStatement s, long id) throws SQLException {
        s.setLong(1, id);
    }


    public List<Food> findByUserFood(long userId) {

       return findList(getUserFoodQuery(),(s) -> {
           try {
               s.setLong(1, userId);
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       });
    }

    public Optional<Food> findByNameAndWeight(String name, long weight, long userId) {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_NAME_AND_WEIGHT_QUERY)) {
            statement.setLong(1, userId);
            statement.setString(2, name);
            statement.setLong(3, weight);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getFromResultSet(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    protected String getFindByIdQuery() {
        return FIND_BY_ID_QUERY;
    }

    @Override
    protected String getFindAllQuery() {
        return FIND_ALL_QUERY;
    }

    private String getUserFoodQuery(){
        return FIND_USER_FOOD_QUERY;
    }
}
