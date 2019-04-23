package model.entity;

public class Food {
    private long id;
    private String name;
    private long carbs;
    private long fat;
    private long protein;
    private long calories;
    private long userId;
    private long weight;

    public Food() {
    }

    public Food(long id, String name, long carbs, long fat,
                long protein, long calories, long userId, long weight) {
        this.id = id;
        this.name = name;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
        this.calories = calories;
        this.userId = userId;
        this.weight = weight;
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

    public long getCarbs() {
        return carbs;
    }

    public void setCarbs(long carbs) {
        this.carbs = carbs;
    }

    public long getFat() {
        return fat;
    }

    public void setFat(long fat) {
        this.fat = fat;
    }

    public long getProtein() {
        return protein;
    }

    public void setProtein(long protein) {
        this.protein = protein;
    }

    public long getCalories() {
        return calories;
    }

    public void setCalories(long calories) {
        this.calories = calories;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
}