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
            return recordDao.getByUserAndDate(user, date);
        }
    }

    public List<Record> getRecords(User user) {
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            RecordDao recordDao = daoFactory.getRecordDao();
            return recordDao.getByUserAndDate(user, LocalDate.now());
        }
    }

    public void insertRecord(Record record) {
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            RecordDao recordDao = daoFactory.getRecordDao();
            recordDao.create(record);
        }
    }

    public void deleteRecord(long recordId) {
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            RecordDao recordDao = daoFactory.getRecordDao();
            recordDao.delete(recordId);
        }
    }

    public void updateRecord(long recordId, long portions) {
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            RecordDao recordDao = daoFactory.getRecordDao();
            recordDao.updateById(recordId, portions);
        }
    }

    public void insertOrUpdateRecord(Record record,List<Record> filteredRecords){
        try (DaoFactory daoFactory = JdbcDaoFactory.getFactory()) {
            RecordDao recordDao = daoFactory.getRecordDao();
            if(isInDailyRecords(record,filteredRecords)) {
                updateRecord(record.getId(), record.getPortions());
            }else{
                insertRecord(record);
            }
        }
    }

    public long getTotalCarbs(List<Record> record) {
        return record.stream().mapToLong(a -> a.getFood().getCarbs() * a.getPortions()).sum();
    }

    public long getTotalFat(List<Record> record) {
        return record.stream().mapToLong(a -> a.getFood().getFat() * a.getPortions()).sum();
    }

    public long getTotalProtein(List<Record> record) {
        return record.stream().mapToLong(a -> a.getFood().getProtein() * a.getPortions()).sum();
    }

    public long getTotalCalories(List<Record> record) {
        return record.stream().mapToLong(a -> a.getFood().getCalories() * a.getPortions()).sum();
    }

    private boolean isInDailyRecords(Record record, List<Record> filteredRecords){
        for (Record recordItem : filteredRecords) {
            if (recordItem.getFood().getId() == record.getFood().getId()) {
                record.setPortions(record.getPortions()+recordItem.getPortions());
                record.setId(recordItem.getId());
                return true;
            }
        }
        return false;
    }


}
