package model;

import exceptions.BeansAmountException;
import exceptions.NoCupsRemainingException;
import exceptions.StaleCoffeeException;
import exceptions.WaterException;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int cupsRemaining;
    private int timeSinceLastBrew;

    public CoffeeMaker(int cupsRemaining, int timeSinceLastBrew){
        this.cupsRemaining = cupsRemaining;
        this.timeSinceLastBrew = timeSinceLastBrew;
    }

    // getters
    public int getCupsRemaining() {
        return cupsRemaining;
    }
    public int getTimeSinceLastBrew() {
        return timeSinceLastBrew;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        return cupsRemaining > 0;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        if (time > 0) {
            this.timeSinceLastBrew = time;
        }
    }

    // MODIFIES: this
    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    public void brew(double beans, double water) throws BeansAmountException, WaterException {
        this.cupsRemaining = 20;
        this.timeSinceLastBrew = 0;
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException {
        if (cupsRemaining > 0 && timeSinceLastBrew < 61) {
            this.cupsRemaining--;
        }else if (timeSinceLastBrew > 60) {
            throw new StaleCoffeeException(getTimeSinceLastBrew());
        } else {
            throw new NoCupsRemainingException();
        }
    }
}
