package ru.khusyainov.gb.java1.hw5.spaceport.area;

import ru.khusyainov.gb.java1.hw5.spaceport.area.parts.Floor;

import java.util.Arrays;

public class Aeroport {
    private final Floor[] floors;

    public Aeroport(Floor[] floors) {
        this.floors = floors;
    }

    public Floor[] getFloors() {
        return floors;
    }

    @Override
    public String toString() {
        return "Aeroport{" +
                "floors=" + Arrays.toString(floors) +
                '}';
    }
}
