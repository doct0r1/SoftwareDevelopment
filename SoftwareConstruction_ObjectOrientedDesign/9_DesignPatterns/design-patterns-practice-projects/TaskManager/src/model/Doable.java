package model;

public abstract class Doable {

    protected Boolean complete;

    public Doable() {
        complete = false;
    }

    // getters
    public boolean getStatus() {
        return complete;
    }

    // abstract methods
    abstract String getDescription();
    abstract void setComplete();
    abstract void display(String indentSpace);
}
