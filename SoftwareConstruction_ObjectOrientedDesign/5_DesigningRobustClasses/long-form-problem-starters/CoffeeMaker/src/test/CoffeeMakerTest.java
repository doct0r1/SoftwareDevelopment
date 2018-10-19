package test;

import exceptions.BeansAmountException;
import exceptions.WaterException;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;


public class CoffeeMakerTest {

    CoffeeMaker coffeeMaker;

    @Before
    public void setUp(){
        coffeeMaker = new CoffeeMaker(3, 5);
    }

    @Test
    public void testTemplate(){
        // TODO: write some more tests
        // This is a template for unit tests
    }

    @Test //(expected = WaterException.class)
    public void testLowWaterException() {
        try {
            coffeeMaker.brew(5, 2);
        } catch (BeansAmountException e) {
            fail("Don't get here");
        } catch (WaterException e) {
            System.out.println("right = " + e.getCupsOfWater());
        }
    }

}
