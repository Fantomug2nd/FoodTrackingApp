package model.entity;

import model.entity.enums.Gender;
import model.entity.enums.Lifestyle;
import model.entity.enums.Role;

public class User {

    private long id;
    private String name;
    private String surname;
    //TODO: add gender to db
    private Gender gender;
    private long age;
    private long height;
    private long weight;
    private String login;
    private String pass;
    private Role role;
    private Lifestyle lifestyle;
    private long intake;

    public User() {
    }

    public User(long id, String name, String surname, Gender gender, long age, long height,
                long weight, String login, String pass, Role role,
                Lifestyle lifestyle, long longake) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.login = login;
        this.pass = pass;
        this.role = role;
        this.lifestyle = lifestyle;
        this.intake = intake;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    public long getIntake() {
        return intake;
    }

    public void setIntake() {
        calculateIntake();
    }

    //TODO: recalculate lifestyle
    private void calculateIntake(){
        intake = (long)(((weight * 10 + height * 6 - 5 * age + 5)* (10 + lifestyle.ordinal())) / 10.);
    }
}