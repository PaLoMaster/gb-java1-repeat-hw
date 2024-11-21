package ru.khusyainov.gb.java1.hw5.spaceport.area.furniture;

public class Instrument {
    private final String name;
    private final String purpose;

    public Instrument(String name, String purpose) {
        this.name = name;
        this.purpose = purpose;
    }

    public String getName() {
        return name;
    }

    public String getPurpose() {
        return purpose;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "name='" + name + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
