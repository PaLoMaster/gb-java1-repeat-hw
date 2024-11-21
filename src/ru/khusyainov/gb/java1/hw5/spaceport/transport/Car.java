package ru.khusyainov.gb.java1.hw5.spaceport.transport;

import ru.khusyainov.gb.java1.hw5.spaceport.area.parts.Door;
import ru.khusyainov.gb.java1.hw5.spaceport.humans.Employee;
import ru.khusyainov.gb.java1.hw5.spaceport.transport.parts.Engine;

import java.util.Arrays;

public class Car {
    private final Door[] doors;
    private Employee[] employees;
    private Engine engine;
    private final int year;

    public Car(Door[] doors, Engine engine, int year) {
        this.doors = doors;
        this.engine = engine;
        this.year = year;
    }

    public Door[] getDoors() {
        return doors;
    }

    public int getYear() {
        return year;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {

    }

    public void enterEmployee(Employee employee) {

    }

    public void enterEmployees(Employee[] employees) {

    }

    public void exitEmployee(Employee employee) {

    }

    public void exitEmployees(Employee[] employees) {

    }

    public Engine getEngine() {
        return engine;
    }

    public void changeEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "doors=" + Arrays.toString(doors) +
                (employees != null ? ", employees=" + Arrays.toString(employees) : "") +
                ", engine=" + engine +
                ", year=" + year +
                '}';
    }
}
