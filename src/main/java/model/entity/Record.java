package model.entity;

import java.time.LocalDate;


public class Record {
    private int id;
    private User user;
    private Food food;
    private int portions;
    private LocalDate date;

    public Record() {
    }

    public Record(int id, User user, Food food,int portions, LocalDate date) {
        this.id = id;
        this.user = user;
        this.food = food;
        this.portions = portions;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
