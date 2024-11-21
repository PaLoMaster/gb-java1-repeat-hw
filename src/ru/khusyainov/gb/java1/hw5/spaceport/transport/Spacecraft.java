package ru.khusyainov.gb.java1.hw5.spaceport.transport;

import ru.khusyainov.gb.java1.hw5.spaceport.transport.parts.SpacecraftLevel;

import java.util.Arrays;

public class Spacecraft {
    private SpacecraftLevel[] spacecraftLevels;
    public Spacecraft(SpacecraftLevel[] spacecraftLevels) {
        this.spacecraftLevels = spacecraftLevels;
    }

    public void addSpacecraftLevel(SpacecraftLevel spacecraftLevel) {

    }

    public void addSpacecraftLevels(SpacecraftLevel[] spacecraftLevels) {

    }

    public void removeSpacecraftLevel(SpacecraftLevel spacecraftLevel) {

    }

    public void removeSpacecraftLevels(SpacecraftLevel[] spacecraftLevels) {

    }

    @Override
    public String toString() {
        return "Spacecraft{" +
                "spacecraftLevels=" + Arrays.toString(spacecraftLevels) +
                '}';
    }
}
