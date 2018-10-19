package model;

import exceptions.*;

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
        if (water < 3) {
            throw new WaterException(water);
        } else if (beans < 5) {
            throw new NotEnoughBeansException(beans, "Not Enough Beans");
        } else if (beans > 20) {
            throw new TooManyBeansException(beans);
        } else {
            this.cupsRemaining = 20;
            this.timeSinceLastBrew = 0;
        }
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
