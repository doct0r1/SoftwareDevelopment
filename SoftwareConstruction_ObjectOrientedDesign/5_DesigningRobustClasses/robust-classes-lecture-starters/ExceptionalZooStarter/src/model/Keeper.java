package model;

import exceptions.AllergyException;
import exceptions.MessyError;
import exceptions.NotHungry;

import java.util.List;

public class Keeper {

    List<Animal> animalsToFeed;

    public Keeper(List<Animal> animals) {
        animalsToFeed = animals;
    }

    public void feed() throws NotHungry, AllergyException {
        System.out.println("Keeper is Feeding the Animals");
        for (Animal animal : animalsToFeed) {
            int eatenTimes = animal.eat();
            System.out.println("Animal has been fed "+ eatenTimes);
        }
        throw new MessyError();
    }


}