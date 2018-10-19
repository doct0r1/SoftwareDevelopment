package model;

import exceptions.BrokeException;
import exceptions.DidntEat;

import java.util.List;

public class Manager {

    private final List<Animal> animalsToManage;
    private final Keeper keeper;

    public Manager(List<Animal> animals, Keeper keeper) {
        this.animalsToManage = animals;
        this.keeper = keeper;
    }

    public void manage() throws BrokeException {
        System.out.println("Manager is managing the Keeper");
        try {
            keeper.feed();
        } catch (DidntEat didntEat) {
            System.out.println("Get the Doctor!!!");
            throw new BrokeException();
        } finally {
            System.out.println("Finally Manager says: Regardless of what happens");
        }
    }


}