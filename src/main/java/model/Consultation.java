package model;

public class Consultation {

    private String description;
    private double value;

    public Consultation(String description, double value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }
}
