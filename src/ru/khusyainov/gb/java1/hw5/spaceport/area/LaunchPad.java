package ru.khusyainov.gb.java1.hw5.spaceport.area;

import ru.khusyainov.gb.java1.hw5.spaceport.humans.Employee;
import ru.khusyainov.gb.java1.hw5.spaceport.movements.Movements;
import ru.khusyainov.gb.java1.hw5.spaceport.transport.Spacecraft;

public class LaunchPad {
    private Employee[] employees;
    private Spacecraft spacecraft;
    private final float width;
    private final float length;

    public LaunchPad(float width, float length) {
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

    public Spacecraft getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(Spacecraft spacecraft) {
        if (this.spacecraft == null) {
            this.spacecraft = spacecraft;
        } else {
            System.out.println("Площадка занята: " + spacecraft.toString());
        }
    }

    public float getWidth() {
        return width;
    }

    public float getLength() {
        return length;
    }
}
