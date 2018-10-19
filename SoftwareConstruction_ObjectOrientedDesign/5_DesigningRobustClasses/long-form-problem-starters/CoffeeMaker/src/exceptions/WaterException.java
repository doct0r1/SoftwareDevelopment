package exceptions;

/**
 * This exception will be thrown when there is not enough water supplied to the machine.
 * (We can imagine that way too much water would provide some physical feedback to the barista by overflowing,
 * so we don’t have to think about this case!)
 */
public class WaterException extends Exception {

    private double cupsOfWater;

    public WaterException(double cupsOfWater) {
        this.cupsOfWater = cupsOfWater;
    }

    public double getCupsOfWater() {
        return cupsOfWater;
    }
}
