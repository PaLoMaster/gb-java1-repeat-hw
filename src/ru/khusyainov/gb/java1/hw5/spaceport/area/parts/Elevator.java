package ru.khusyainov.gb.java1.hw5.spaceport.area.parts;

import ru.khusyainov.gb.java1.hw5.spaceport.humans.Employee;
import ru.khusyainov.gb.java1.hw5.spaceport.movements.Movements;

import java.util.Arrays;

public class Elevator {
    private final float loadCapacity;
    private float currentLoading;
    private Employee[] employees;
    private int currentFloor;
    private final Floor[] floors;
    private boolean moving;
    private boolean doorLocked;

    public Elevator(float loadCapacity, int currentFloor, Floor[] floors) {
        this.loadCapacity = loadCapacity;
        currentLoading = 0;
        this.currentFloor = currentFloor;
        this.floors = floors;
        moving = false;
        doorLocked = true;
    }

    public float getLoadCapacity() {
        return loadCapacity;
    }

    public Floor getCurrentFloor() {
        return floors[currentFloor];
    }

    public Floor[] getFloors() {
        return floors;
    }

    public boolean isMoving() {
        return moving;
    }

    public float getCurrentLoading() {
        return currentLoading;
    }

    public void load(float cargoWeight) {
        System.out.print("Лифт загрузился с " + currentLoading + " до ");
        currentLoading += cargoWeight;
        System.out.println(currentLoading + ".");
    }

    public void unload(float cargoWeight) {
        if (cargoWeight > this.currentFloor) {
            System.out.println("В лифте столько не было. Разгрузился с " + currentLoading + " до нуля.");
            currentLoading = 0;
        } else {
            System.out.print("Лифт разгрузился с " + currentLoading + " до ");
            currentLoading -= cargoWeight;
            System.out.println(currentLoading + ".");
        }
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        if (this.employees != null) {
            enterEmployees(employees);
        } else {
            this.employees = employees;
        }
    }

    public void enterEmployee(Employee employee) {
        enterEmployees(new Employee[]{employee});
    }

    public void enterEmployees(Employee[] employees) {
        this.employees = Movements.moveIn(this.employees, employees);
        for (Employee employee : employees) {
            currentLoading += employee.getWeight();
        }
    }

    public void exitEmployee(Employee employee) {
        exitEmployees(new Employee[]{employee});
    }

    public void exitEmployees(Employee[] employees) {
        this.employees = Movements.moveOut(this.employees, employees);
        for (Employee employee : employees) {
            currentLoading -= employee.getWeight();
        }
    }

    private boolean isLoadPermissible() {
        return currentLoading <= loadCapacity;
    }

    public boolean isDoorLocked() {
        return doorLocked;
    }

    public void start(int toFloor) {
        if (!isLoadPermissible()) {
            System.out.println("Лифт перегружен! Движение невозможно.");
        } else if (!isFloorAvailable(toFloor)) {
            System.out.println("Этаж " + toFloor + " недоступен в этом лифте.");
        } else {
            movement(currentFloor, toFloor);
        }
    }

    private void movement(int fromFloor, int toFloor) {
        doorLocked = true;
        moving = true;
        System.out.println("Поехали...");
        int direction;
        if (fromFloor < toFloor) {
            direction = 1;
        } else {
            direction = -1;
        }
        for (int i = fromFloor; direction > 0 ? i < toFloor : i > toFloor; i += direction) {
            currentFloor = i;
            System.out.println("Проезжаем этаж " + floors[i]);
        }
        stop(toFloor);
    }

    public void stop(int toStop) {
        moving = false;
        doorLocked = false;
        currentFloor = toStop;
        System.out.println("Прибыли на этаж " + floors[toStop]);
    }

    private boolean isFloorAvailable(int floor) {
        return floor < floors.length;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "loadCapacity=" + loadCapacity +
                ", currentLoading=" + currentLoading +
                ", employees=" + Arrays.toString(employees) +
                ", currentFloor=" + currentFloor +
                ", floors=" + Arrays.toString(floors) +
                ", moving=" + moving +
                ", doorLocked=" + doorLocked +
                '}';
    }
}
