package model;


public class Brake {

    private Wheel wheel = new Wheel();

    public void apply() {
        wheel.slow();
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }


}