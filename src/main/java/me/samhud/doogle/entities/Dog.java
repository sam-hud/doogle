package me.samhud.doogle.entities;

import javax.persistence.*;

@Entity
public class Dog {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String breed;

    @Column()
    private String color;

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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }

    public int getWalksPerDay() {
        return walksPerDay;
    }

    public void setWalksPerDay(int walksPerDay) {
        this.walksPerDay = walksPerDay;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    @Column()
    private String foodPreference;

    @Column()
    private int walksPerDay;

    @Column()
    private int age;

    @ManyToOne
    @JoinColumn(name = "shelterid", nullable = false)
    private Shelter shelter;

}
