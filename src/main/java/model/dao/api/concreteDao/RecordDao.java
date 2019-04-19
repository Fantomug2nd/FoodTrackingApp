package model.dao.api.concreteDao;

import model.dao.api.GenericDao;
import model.entity.Record;
import model.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface RecordDao extends GenericDao<Record> {
    public List<Record> getByUserAndDate(User user, LocalDate date) ;
}