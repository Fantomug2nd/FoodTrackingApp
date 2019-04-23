package model.dao.jdbc.concreteDao;

import model.dao.api.concreteDao.FoodDao;
import model.dao.api.concreteDao.RecordDao;
import model.dao.api.concreteDao.UserDao;
import model.dao.jdbc.JdbcGenericDao;
import model.entity.Food;
import model.entity.Record;
import model.entity.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JdbcRecordDao extends JdbcGenericDao<Record> implements RecordDao {
    private static final String FIND_BY_USER_QUERY = "SELECT record_id, user_id, food_id, date, portions FROM records WHERE user_id=? ";
    private static final String INSERT_QUERY = "INSERT INTO records ( user_id, food_id, date,portions) VALUES (?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT record_id, user_id, food_id, date,portions FROM records WHERE record_id=?";
    private static final String FIND_ALL_QUERY = "SELECT record_id, user_id, food_id, date,portions FROM records";
    private static final String UPDATE_QUERY = "UPDATE records SET user_id=?, food_id=?, date=?,portions=? WHERE record_id=?";
    private static final String UPDATE_BY_ID_QUERY = "UPDATE records SET portions=? WHERE record_id=?";
    private static final String FIND_BY_DATE_AND_USER_QUERY = "SELECT record_id, user_id, food_id, date, portions FROM records WHERE user_id=? AND date=?";
    private static final String DELETE_QUERY ="DELETE FROM records WHERE record_id=?";
    private static final int NUMBER_OF_FIELDS = 5;
    private UserDao userDao;
    private FoodDao foodDao;

    public JdbcRecordDao(Connection connection, UserDao userDao, FoodDao foodDao) {
        super(connection);
        this.userDao = userDao;
        this.foodDao = foodDao;
    }


    @Override
    protected void setUpdateQueryParams(PreparedStatement s, Record record) throws SQLException {
        setRecordParams(s, record);
        s.setLong(NUMBER_OF_FIELDS, record.getId());
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    protected String getInsertQuery() {
        return INSERT_QUERY;
    }

    protected void setInsertQueryParams(PreparedStatement s, Record record) throws SQLException {
        setRecordParams(s, record);
    }

    private void setRecordParams(PreparedStatement s, Record record) throws SQLException {
        // user_id
        s.setLong(1, record.getUser().getId());
        // food_id
        s.setLong(2, record.getFood().getId());
       // date
        setLocalDate(s, 3, record.getDate());

        s.setLong(4, record.getPortions());

    }

    private void setLocalDate(PreparedStatement s, int parameterIndex, LocalDate date) throws SQLException {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = dateTimeFormatter.format(date);
        s.setString(parameterIndex, formattedDate);
    }

    @Override
    protected void setFindByIdQueryParams(PreparedStatement s, long id) throws SQLException {
        s.setLong(1, id);
    }

    @Override
    protected String getFindByIdQuery() {
        return FIND_BY_ID_QUERY;
    }

    @Override
    protected Record getFromResultSet(ResultSet resultSet) throws SQLException {
        Record record = new Record();
        record.setId(resultSet.getLong("record_id"));
        // reading food
        record.setFood(loadFood(resultSet));
        // reading user
        record.setUser(loadUser(resultSet));
        // reading remain primitive fields
        record.setDate(resultSet.getObject("date", LocalDate.class));
        record.setPortions(resultSet.getLong("portions"));
        return record;
    }

    private Food loadFood(ResultSet resultSet) throws SQLException {
        long foodId = resultSet.getLong("food_id");
        return foodDao.findById(foodId).get();
    }

    private User loadUser(ResultSet resultSet) throws SQLException {
        long userId = resultSet.getLong("user_id");
        return userDao.findById(userId).get();
    }

    @Override
    protected String getFindAllQuery() {
        return FIND_ALL_QUERY;
    }


    public List<Record> getByUser(User user) {
        return findList(FIND_BY_USER_QUERY, (s) -> {
            try {
                s.setLong(1, user.getId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public List<Record> getByUserAndDate(User user,LocalDate date) {
        return findList(FIND_BY_DATE_AND_USER_QUERY, (s) -> {
            try {
                s.setLong(1, user.getId());
                setLocalDate(s, 2 , date);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement statement = getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateById(long id, long portions){
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_BY_ID_QUERY)) {
            statement.setLong(1, portions);
            statement.setLong(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

