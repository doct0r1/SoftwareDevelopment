package main;

import exceptions.BeansAmountException;
import exceptions.NoCupsRemainingException;
import exceptions.StaleCoffeeException;
import exceptions.WaterException;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args){
        CoffeeMaker coffeeMaker = new CoffeeMaker(1, 11);

        System.out.println(coffeeMaker.areCupsRemaining());

//        try {
//            coffeeMaker.brew(11.0, 11);
//        } catch (BeansAmountException e) {
//            System.out.println(e.getBeans());
//        } catch (WaterException e) {
//            System.out.println("Cups of water is: " + e.getCupsOfWater());
//        }

        coffeeMaker.setTimeSinceLastBrew(61);

        System.out.println(coffeeMaker.getCupsRemaining());

        System.out.println(coffeeMaker.getTimeSinceLastBrew());

        try {
            coffeeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println("Cups error = " + coffeeMaker.getCupsRemaining());
        } catch (StaleCoffeeException e) {
            System.out.println("Time error = " + coffeeMaker.getTimeSinceLastBrew());
        }
    }
}