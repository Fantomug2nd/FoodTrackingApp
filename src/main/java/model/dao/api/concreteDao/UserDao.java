package model.dao.api.concreteDao;

import model.dao.api.GenericDao;
import model.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    Optional<User> findByLogin(String login);
}