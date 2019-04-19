package model.entity;

import model.entity.enums.Gender;
import model.entity.enums.Lifestyle;
import model.entity.enums.Role;

public class User {

    private int id;
    private String name;
    private String surname;
    private Gender gender;
    private int age;
    private int height;
    private int weight;
    private String login;
    private String pass;
    private Role role;
    private Lifestyle lifestyle;
    private int intake;

    public User() {
    }

    public User(int id, String name, String surname, Gender gender, int age, int height,
                int weight, String login, String pass, Role role,
                Lifestyle lifestyle, int intake) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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

    public int getIntake() {
        return intake;
    }

    public void setIntake(int intake) {
        this.intake = intake;
    }

}