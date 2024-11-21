package ru.khusyainov.gb.java1.hw5.spaceport.area;

import ru.khusyainov.gb.java1.hw5.spaceport.humans.Employee;
import ru.khusyainov.gb.java1.hw5.spaceport.movements.Movements;
import ru.khusyainov.gb.java1.hw5.spaceport.transport.Spacecraft;

import java.util.Arrays;

public class Runway {
    private Employee[] employees;
    private Spacecraft[] spacecrafts;
    private final float width;
    private final float length;

    public Runway(float width, float length) {
        this.width = width;
        this.length = length;
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

    public Spacecraft[] getSpacecrafts() {
        return spacecrafts;
    }

    public void moveInSpacecraft(Spacecraft spacecraft) {
        moveInSpacecrafts(new Spacecraft[]{spacecraft});
    }

    public void moveInSpacecrafts(Spacecraft[] spacecrafts) {
        this.spacecrafts = Movements.moveIn(this.spacecrafts, spacecrafts);
    }

    public void moveOutSpacecraft(Spacecraft spacecraft) {
        moveOutSpacecrafts(new Spacecraft[]{spacecraft});
    }

    public void moveOutSpacecrafts(Spacecraft[] spacecrafts) {
        this.spacecrafts = Movements.moveOut(this.spacecrafts, spacecrafts);
    }

    public float getWidth() {
        return width;
    }

    public float getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Runway{" +
                (employees != null ? "employees=" + Arrays.toString(employees) + ", " : "") +
                (spacecrafts != null ? "spacecrafts=" + Arrays.toString(spacecrafts) + ", " : "") +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
