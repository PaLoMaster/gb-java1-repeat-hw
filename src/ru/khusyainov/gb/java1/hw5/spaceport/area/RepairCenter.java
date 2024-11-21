package ru.khusyainov.gb.java1.hw5.spaceport.area;

import ru.khusyainov.gb.java1.hw5.spaceport.area.furniture.Instrument;
import ru.khusyainov.gb.java1.hw5.spaceport.area.parts.Floor;
import ru.khusyainov.gb.java1.hw5.spaceport.movements.Movements;

public class RepairCenter {
    private Instrument[] instruments;
    private final Floor[] floors;

    public RepairCenter(Floor[] floors) {
        this.floors = floors;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public Instrument[] getInstruments() {
        return instruments;
    }

    public void setInstruments(Instrument[] instruments) {
        moveInInstruments(instruments);
    }

    public void moveInInstrument(Instrument instrument) {
        moveInInstruments(new Instrument[]{instrument});
    }

    public void moveInInstruments(Instrument[] instruments) {
        this.instruments = Movements.moveIn(this.instruments, instruments);
    }

    public void moveOutInstrument(Instrument instrument) {
        moveOutInstruments(new Instrument[]{instrument});
    }

    public void moveOutInstruments(Instrument[] instruments) {
        this.instruments = Movements.moveOut(this.instruments, instruments);
    }
}
