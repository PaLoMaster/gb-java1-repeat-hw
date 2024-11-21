package ru.khusyainov.gb.java1.hw5.spaceport.area.parts;

import ru.khusyainov.gb.java1.hw5.spaceport.humans.Employee;
import ru.khusyainov.gb.java1.hw5.spaceport.movements.Movements;

import java.util.Arrays;

public class Floor {
    private final Room[] rooms;
    private final Elevator[] elevators;
    private final Staircase[] staircases;
    private Employee[] employees;

    public Floor(Room[] rooms, Elevator[] elevators, Staircase[] staircases) throws Exception {
        if (rooms == null || staircases == null) {
            String message = "Этаж не может быть без " +
                    (rooms == null ? "комнат (как минимум он сам - одна большая комната) " : "") +
                    (rooms == null && staircases == null ? "и " : "") +
                    (staircases == null ? "лестниц" : "") +
                    "!";
            System.out.println(message);
            throw new Exception(message);
        }
        this.rooms = rooms;
        this.elevators = elevators;
        this.staircases = staircases;
    }

    public Floor(Room[] rooms, Staircase[] staircases) throws Exception {
        this(rooms, null, staircases);
    }

    public Room[] getRooms() {
        return rooms;
    }

    public Elevator[] getElevators() {
        return elevators;
    }

    public Staircase[] getStaircases() {
        return staircases;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        enterEmployees(employees);
    }

    public void enterEmployee(Employee employee) {
        enterEmployees(new Employee[]{employee});
    }

    public void enterEmployees(Employee[] employees) {
        this.employees = Movements.moveIn(this.employees, employees);
    }

    public void exitEmployee(Employee employee) {
        exitEmployees(new Employee[]{employee});
    }

    public void exitEmployees(Employee[] employees) {
        this.employees = Movements.moveOut(this.employees, employees);
    }

    @Override
    public String toString() {
        return "Floor{" +
                "rooms=" + Arrays.toString(rooms) +
                (elevators != null ? ", elevators=" + Arrays.toString(elevators) : "") +
                ", staircases=" + Arrays.toString(staircases) +
                (employees != null ? ", employees=" + Arrays.toString(employees) : "") +
                '}';
    }
}
