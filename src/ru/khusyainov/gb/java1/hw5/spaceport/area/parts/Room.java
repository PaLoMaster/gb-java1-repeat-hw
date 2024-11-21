package ru.khusyainov.gb.java1.hw5.spaceport.area.parts;

import ru.khusyainov.gb.java1.hw5.spaceport.area.furniture.Chair;
import ru.khusyainov.gb.java1.hw5.spaceport.area.furniture.Table;
import ru.khusyainov.gb.java1.hw5.spaceport.humans.Employee;
import ru.khusyainov.gb.java1.hw5.spaceport.movements.Movements;

import java.util.Arrays;

public class Room {
    private final Floor floor;
    private Employee[] employees;
    private Chair[] chairs;
    private Table[] tables;
    private final Window[] windows;
    private final Door[] doors;

    public Room(Floor floor, Window[] windows, Door[] doors) {
        this.floor = floor;
        this.windows = windows;
        this.doors = doors;
    }

    public void enterEmployee(Employee employee) {
        enterEmployees(new Employee[]{employee});
    }

    public void enterEmployees(Employee[] employees) {
        this.employees = Movements.moveIn(this.employees, employees);
        floor.exitEmployees(employees);
    }

    public void exitEmployee(Employee employee) {
        exitEmployees(new Employee[]{employee});
    }

    public void exitEmployees(Employee[] employees) {
        this.employees = Movements.moveOut(this.employees, employees);
        floor.enterEmployees(employees);
    }

    public void moveInChair(Chair chair) {
        moveInChairs(new Chair[]{chair});
    }

    public void moveInChairs(Chair[] chairs) {
        this.chairs = Movements.moveIn(this.chairs, chairs);
    }

    public void moveOutChair(Chair chair) {
        moveOutChairs(new Chair[]{chair});
    }

    public void moveOutChairs(Chair[] chairs) {
        this.chairs = Movements.moveOut(this.chairs, chairs);
    }

    public void moveInTable(Table table) {
        moveInTables(new Table[]{table});
    }

    public void moveInTables(Table[] tables) {
        this.tables = Movements.moveIn(this.tables, tables);
    }

    public void moveOutTable(Table table) {
        moveOutTables(new Table[]{table});
    }

    public void moveOutTables(Table[] tables) {
        this.tables = Movements.moveOut(this.tables, tables);
    }

    public boolean isDoorsLocked() {
        for (Door door : doors) {
            if (!door.getLock().isLocked()) {
                return false;
            }
        }
        return true;
    }

    public boolean isDoorsClosed() {
        for (Door door : doors) {
            if (door.isOpened()) {
                return false;
            }
        }
        return true;
    }

    public boolean isWindowsClosed() {
        for (Window window : windows) {
            if (window.isOpened()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Room{" +
                "employees=" + Arrays.toString(employees) +
                ", chairs=" + Arrays.toString(chairs) +
                ", tables=" + Arrays.toString(tables) +
                ", windows=" + Arrays.toString(windows) +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}
