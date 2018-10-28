package model;

import java.util.ArrayList;
import java.util.List;

public class Dish {

    private String name;
    private String desciption;
    private List<String> ingerediants;
    private String recepy;

    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, String description, List<String> ingeradiants, String recopy) {
        this.name = name;
        this.desciption = description;
        this.ingerediants = new ArrayList<>();
        this.recepy = recopy;
    }


    public String getName() {
        return name;
    }

    public String getDesciption() {
        return desciption;
    }

    public List<String> getIngerediants() {
        return ingerediants;
    }

    public String getRecepy() {
        return recepy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void setIngerediants(List<String> ingerediants) {
        this.ingerediants = ingerediants;
    }

    public void setRecepy(String recepy) {
        this.recepy = recepy;
    }
}
