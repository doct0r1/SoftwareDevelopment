package test;

import exceptions.AllergyException;
import exceptions.NotHungry;
import model.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class AnimalTest {

    @Test
    public void eatIsHungryNotAllergic() {
        // expecting eatenTimes to be 1, and no exceptions thrown.
        Animal animal = new Animal(true, false);
        int eatenTimes = 0;

        try {
            eatenTimes = animal.eat();
        } catch (NotHungry notHungry) {
            fail("Got Allergic when it shouldn't!");
        } catch (AllergyException e) {
            fail("Got not hungry when it shouldn't!");
        }

        assertTrue(eatenTimes == 1);
    }

    @Test
    public void eatNotHungryNotAllergic() {
        // expecting a NotHungry Exception to be thrown
        // and for eatenTimes to remain 0
        Animal animal = new Animal(false, false);
        int eatenTimes = 0;

        try {
            eatenTimes = animal.eat();
        } catch (AllergyException e) {
            fail("Got Allergic when it shouldn't!");
        } catch (NotHungry notHungry) {
            // don't have to do anything here!
        }

        assertTrue(eatenTimes == 0);
    }
}