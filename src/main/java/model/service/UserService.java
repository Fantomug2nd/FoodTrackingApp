
package model.service;

import model.dao.api.DaoFactory;
import model.dao.api.concreteDao.UserDao;
import model.dao.jdbc.JdbcDaoFactory;
import model.entity.User;

import java.util.Objects;
import java.util.Optional;


public class UserService {
    public void signUp(User user) {
        try (DaoFactory factory = JdbcDaoFactory.getFactory()) {
            UserDao userDao = factory.getUserDao();
            userDao.create(user);
        }
    }

    public boolean signIn(String login, String password) {
        try (DaoFactory factory = JdbcDaoFactory.getFactory()) {
            UserDao userDao = factory.getUserDao();
            Optional<User> user = userDao.findByLogin(login);
            return user.filter(value -> verifyPassword(value, password)).isPresent();
        }
    }

    public Optional<User> getUserByLogin(String login) {
        try (DaoFactory factory = JdbcDaoFactory.getFactory()) {
            UserDao userDao = factory.getUserDao();
            return userDao.findByLogin(login);
        }
    }

    private boolean verifyPassword(User user, String password) {
        return Objects.equals(user.getPass(), password);
    }
}

