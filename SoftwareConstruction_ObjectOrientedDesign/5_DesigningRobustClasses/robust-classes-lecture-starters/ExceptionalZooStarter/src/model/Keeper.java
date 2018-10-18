package model;

import exceptions.NotHungry;

import java.util.List;

public class Keeper {

    List<Animal> animalsToFeed;

    public Keeper(List<Animal> animals) {
        animalsToFeed = animals;
    }

    public void feed() throws NotHungry {
        System.out.println("Keeper is Feeding the Animals");
        for (Animal animal : animalsToFeed) {
            int eatenTimes = animal.eat();
            System.out.println("Animal has been fed "+ eatenTimes);
        }
    }


}