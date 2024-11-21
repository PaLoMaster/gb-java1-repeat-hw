package ru.khusyainov.gb.java1.hw5.spaceport.area;

import ru.khusyainov.gb.java1.hw5.spaceport.area.parts.Floor;

import java.util.Arrays;

public class Warehouse {
    private final Floor[] floor;

    public Warehouse(Floor[] floor) {
        this.floor = floor;
    }

    public Floor[] getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "floor=" + Arrays.toString(floor) +
                '}';
    }
}
