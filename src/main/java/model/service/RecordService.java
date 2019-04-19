package model.service;

import model.dao.api.DaoFactory;
import model.dao.api.concreteDao.RecordDao;
import model.dao.jdbc.JdbcDaoFactory;
import model.entity.Record;
import model.entity.User;

import java.time.LocalDate;
import java.util.List;

public class RecordService {

    public List<Record> findByDay(User user, LocalDate date) {
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            RecordDao recordDao = daoFactory.getRecordDao();
           return recordDao.getByUserAndDate(user,date);
        }
    }

    public List<Record> getRecords(User user) {
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            RecordDao recordDao = daoFactory.getRecordDao();
            return recordDao.getByUserAndDate(user,LocalDate.now());
        }
    }
    public void insertRecord(Record record){
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            RecordDao recordDao = daoFactory.getRecordDao();
            recordDao.create(record);
        }
    }
}
