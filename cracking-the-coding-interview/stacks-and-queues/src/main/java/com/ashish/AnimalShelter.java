package com.ashish;

/**
 * @author Ashish Sharma on 1/12/2017.
 * @since 1/12/2017
 */
public class AnimalShelter {


    private final Queue dogQueue;
    private final Queue catQueue;
    private int arrivalOrderAge;

    public AnimalShelter() {
        dogQueue = new Queue<Dog>();
        catQueue = new Queue<Cat>();
        arrivalOrderAge = 0;
    }

    public void enqueue(Animal animal) {
        if (animal instanceof Dog) {
            animal.setArrivalOrderAge(arrivalOrderAge);
            dogQueue.enqueue(animal);
        } else if (animal instanceof Cat) {
            animal.setArrivalOrderAge(arrivalOrderAge);
            catQueue.enqueue(animal);
        }
        arrivalOrderAge++;
    }

    public Animal dequeueAny() {

        return null;
    }

    public Dog dequeueDog() {
        return null;
    }

    public Cat dequeueCat() {
        return null;
    }
}
