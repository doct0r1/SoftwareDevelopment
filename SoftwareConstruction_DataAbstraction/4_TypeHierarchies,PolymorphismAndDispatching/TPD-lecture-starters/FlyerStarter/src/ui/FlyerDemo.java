package ui;

import model.*;

public class FlyerDemo {

    // NOTE: this project goes with the Subclasses & Extends, Pt. 2 (Extending) Video

    public static void main(String[] args) {
        Bird birdie = new Bird();
        Airplane planie = new Airplane();
        Cafe cafePlane = new Airplane();
        Flyer flyerPlane = new Airplane();
        Flyer priPlane = new PrivatePlane();
        PrivatePlane pp = new PrivatePlane();


        ((PrivatePlane) priPlane).bringWarmTowels();
        pp.bringWarmTowels();

        birdie.fly();
        cafePlane.serveDrinks();

        FlyerDemo fd = new FlyerDemo();
        fd.lunchService(cafePlane);
        fd.firstPartOfFlight(planie);
    }

    private void lunchService(Cafe c){
        c.serveDrinks();
        c.serveSnacks();
    }

    private void firstPartOfFlight(Airplane a){
        a.takeOff();
        a.serveDrinks();
    }
}