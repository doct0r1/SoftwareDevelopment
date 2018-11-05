package model;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Bidder implements Observer {

    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;

    public Bidder(String name, double maxBid) {
        this.name = name;
        personalBid = 0.0;
        currentBid = 0.0;
        this.maxBid = maxBid;
        new Auctioneer(name).addObserver(this);
    }

    public String getName() {
        return name;
    }

    public double getPersonalBid() {
        return personalBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public double getMacBid() {
        return maxBid;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.currentBid = (double) arg;
        System.out.println("Update received for: " + name + ", current bid is at: $" + currentBid);

        if (currentBid < maxBid) {
            makeBid(currentBid);
        } else {
            System.out.println(name + " can't bid any higher!");
        }
    }

    /**
     * This is a utility function which randomly generates a number from currentBid to maxBid
     * and sets it as this Bidder's personalBid
     *
     * @param currentBid the current bid
     */
    public void makeBid(double currentBid) {
        this.personalBid += new Random().nextInt(10) + 1;
        System.out.println(name + "'s bid is: " + personalBid);
    }
}
