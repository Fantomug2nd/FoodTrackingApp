package model.entity;

import java.time.LocalDate;


public class Record {
    private long id;
    private User user;
    private Food food;
    private long portions;
    private LocalDate date;

    public Record() {
    }

    public Record(long id, User user, Food food,long portions, LocalDate date) {
        this.id = id;
        this.user = user;
        this.food = food;
        this.portions = portions;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public long getPortions() {
        return portions;
    }

    public void setPortions(long portions) {
        this.portions = portions;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
