package ru.khusyainov.gb.java1.hw5.spaceport.area.parts;

import java.util.Arrays;

public class Staircase {
    private final int numberOfSteps;
    private final int height;
    private final Floor floorFrom;
    private final Floor floorTo;
    private final String position;
    private final Door[] doors;

    public Staircase(int numberOfSteps, int height, Floor floorFrom, Floor floorTo, String position, Door[] doors) {
        this.numberOfSteps = numberOfSteps;
        this.height = height;
        this.floorFrom = floorFrom;
        this.floorTo = floorTo;
        this.position = position;
        this.doors = doors;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public int getHeight() {
        return height;
    }

    public Floor getFloorFrom() {
        return floorFrom;
    }

    public Floor getFloorTo() {
        return floorTo;
    }

    public String getPosition() {
        return position;
    }

    public Door[] getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return "Staircase{" +
                "numberOfSteps=" + numberOfSteps +
                ", height=" + height +
                ", floorFrom=" + floorFrom +
                ", floorTo=" + floorTo +
                ", position='" + position + '\'' +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}
