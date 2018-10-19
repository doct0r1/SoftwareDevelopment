package model;

import exceptions.AllergyException;
import exceptions.NotHungry;

public class Animal {

    private boolean isHungry = true;
    private boolean isAllergic = true;
    private int eaten = 0;

    // getters
    public boolean isAllergic() { return isAllergic; }

    public int eat() throws NotHungry, AllergyException {
        if (!isHungry) {
            System.out.println("Animal not Hungry!!!");
            throw new NotHungry();
        }
        if (isAllergic) {
            System.out.println("Animal is Allergic");
            throw new AllergyException();
        }
        isHungry = false;
        eaten++;
        return eaten;
    }
}