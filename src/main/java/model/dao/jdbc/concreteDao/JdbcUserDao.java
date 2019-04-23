package model.dao.jdbc.concreteDao;

import model.dao.api.concreteDao.UserDao;
import model.dao.jdbc.JdbcGenericDao;
import model.entity.User;
import model.entity.enums.Lifestyle;
import model.entity.enums.Role;
import model.exceptions.AlreadyExistException;


import java.sql.*;
import java.util.Optional;



public class JdbcUserDao extends JdbcGenericDao<User> implements UserDao {
    private static final String INSERT_QUERY = "INSERT INTO users " +
            "(name, surname, age, height, weight, login, password, status_id, lifestyle_id, intake)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_LOGIN_QUERY = "SELECT user_id, name, surname, age, height, weight, login, password, status_id, lifestyle_id, intake FROM users WHERE login=?";
    private static final String UPDATE_QUERY = "UPDATE users SET  user_id=?, name=?, surname=?, age=?, height=?, weight=?, login=?, password=?, status_id=?, lifestyle_id=?, intake=? WHERE user_id=?";
    private static final String FIND_ALL_QUERY = "SELECT user_id, name, surname, age, height, weight, login, password, status_id, lifestyle_id, intake  FROM users";
    private static final String FIND_BY_ID_QUERY = "SELECT user_id, name, surname, age, height, weight, login, password, status_id, lifestyle_id, intake  FROM users WHERE user_id=?";



    public JdbcUserDao(Connection connection) {
        super(connection);
    }

    @Override
    public void create(User entity) throws AlreadyExistException {
        try (PreparedStatement s = getConnection().prepareStatement(getInsertQuery(), Statement.RETURN_GENERATED_KEYS)) {
            setInsertQueryParams(s, entity);
            s.executeUpdate();
        entity.setId(getInsertionId(s));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void setUpdateQueryParams(PreparedStatement s, User user) throws SQLException {
        int nextParamIndex = setUserParams(s, user);
        s.setLong(nextParamIndex, user.getId());
    }

    @Override
    protected String getUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    protected String getInsertQuery() {
        return INSERT_QUERY;
    }

    @Override
    protected void setInsertQueryParams(PreparedStatement s, User user) throws SQLException {
        setUserParams(s, user);
    }

    private int setUserParams(PreparedStatement s, User user) throws SQLException {
        s.setString(1, user.getName());
        s.setString(2, user.getSurname());
        s.setLong(3, user.getAge());
        s.setLong(4, user.getHeight());
        s.setLong(5, user.getWeight());
        s.setString(6, user.getLogin());
        s.setString(7, user.getPass());
        s.setLong(8, user.getRole().ordinal()+1);
        s.setLong(9, user.getLifestyle().ordinal()+1);
        s.setLong(10, user.getIntake());
        return 10 + 1;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_LOGIN_QUERY)) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getFromRow(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User getFromRow(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("user_id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setAge(resultSet.getLong("age"));
        user.setHeight(resultSet.getLong("height"));
        user.setWeight(resultSet.getLong("weight"));
        user.setLogin(resultSet.getString("login"));
        user.setPass(resultSet.getString("password"));
        user.setRole(Role.values[(resultSet.getInt("status_id"))-1]);
        user.setLifestyle(Lifestyle.values[(resultSet.getInt("lifestyle_id"))-1]);
        user.setIntake();
        return user;
    }

    @Override
    protected User getFromResultSet(ResultSet resultSet) throws SQLException {
        return getFromRow(resultSet);
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
    protected String getFindAllQuery() {
        return FIND_ALL_QUERY;
    }
}

