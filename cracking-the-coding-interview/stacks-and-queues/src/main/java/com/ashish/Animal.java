package com.ashish;

/**
 * @author Ashish Sharma on 1/12/2017.
 * @since 1/12/2017.
 */
public abstract class Animal {
    private int arrivalOrderAge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public int getArrivalOrderAge() {
        return arrivalOrderAge;
    }

    public void setArrivalOrderAge(int arrivalOrderAge) {
        this.arrivalOrderAge = arrivalOrderAge;
    }

    boolean isOlderThan(Animal animal) {
        return this.getArrivalOrderAge() > animal.getArrivalOrderAge();
    }
}
