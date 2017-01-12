package com.ashish;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 3.7
 * <p>
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals
 * at the shelter, or they can select whether they would prefer a dog or a cat (and will
 * receive the oldest animal of that type). They cannot select which specific animal they
 * would like.
 * <p>
 * Create the data structures to maintain this system and implement operations
 * such as enqueue, dequeueAny, dequeueDog and dequeueCat.
 * You may use the built-in LinkedList data structure.
 * <p>
 *
 * @author Ashish Sharma on 1/12/2017.
 * @since 1/12/2017
 */
public class AnimalShelterTest {

    private AnimalShelter animalShelter;

    @BeforeMethod
    public void initialize() {
        animalShelter = new AnimalShelter();
    }

    @Test
    public void testAnimalShelter() {
        Animal cat1 = new Cat("cat1");
        Animal dog1 = new Dog("dog1");
        animalShelter.enqueue(cat1);
        animalShelter.enqueue(dog1);
    }

    @Test
    public void testAdoptAnyAnimal() {
        Animal cat1 = new Cat("cat1");
        Animal dog1 = new Dog("dog1");
        Animal cat2 = new Cat("cat2");
        Animal dog2 = new Dog("dog2");
        Animal cat3 = new Cat("cat3");
        animalShelter.enqueue(cat1);
        animalShelter.enqueue(dog1);
        animalShelter.enqueue(cat2);
        animalShelter.enqueue(dog2);
        animalShelter.enqueue(cat3);

        Assert.assertEquals(animalShelter.dequeueAny().getName(), cat1.getName());
        Assert.assertEquals(animalShelter.dequeueAny().getName(), dog1.getName());
        Assert.assertEquals(animalShelter.dequeueAny().getName(), cat2.getName());
    }

    @Test
    public void testAdoptCatOrDog() {
        Animal cat1 = new Cat("cat1");
        Animal dog1 = new Dog("dog1");
        Animal cat2 = new Cat("cat2");
        Animal dog2 = new Dog("dog2");
        Animal cat3 = new Cat("cat3");
        animalShelter.enqueue(cat1);
        animalShelter.enqueue(dog1);
        animalShelter.enqueue(cat2);
        animalShelter.enqueue(dog2);
        animalShelter.enqueue(cat3);

        Assert.assertEquals(animalShelter.dequeueCat().getName(), cat1.getName());
        Assert.assertEquals(animalShelter.dequeueDog().getName(), dog1.getName());
        Assert.assertEquals(animalShelter.dequeueCat().getName(), cat2.getName());
        Assert.assertEquals(animalShelter.dequeueDog().getName(), dog2.getName());
    }
}
