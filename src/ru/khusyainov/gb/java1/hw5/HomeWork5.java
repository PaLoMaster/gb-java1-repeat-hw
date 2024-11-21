package ru.khusyainov.gb.java1.hw5;

import ru.khusyainov.gb.java1.hw5.company.Employee;

public class HomeWork5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5]; // Вначале объявляем массив объектов
        employees[0] = new Employee("Ivanov Ivan", "Main engineer", "iivanov@company.com",
                "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
        employees[1] = new Employee("Petrov Ivan", "Engineer", "ipetrov@company.com",
                "892312313", 20000, 45); // потом для каждой ячейки массива задаем объект
        employees[2] = new Employee("Sidorov Ivan", "Engineer", "isidorov@company.com",
                "892312314", 20000, 39); // потом для каждой ячейки массива задаем объект
        employees[3] = new Employee("Sidorov Petr", "Engineer", "psidorov@company.com",
                "892312315", 20000, 25); // потом для каждой ячейки массива задаем объект
        employees[4] = new Employee("Abdulaev Rustam", "Engineer", "rabdulaev@company.com",
                "892312316", 23000, 27); // потом для каждой ячейки массива задаем объект

        int limitAge = 40;

        System.out.println("Сотрудники старше " + limitAge + " лет:");
        for (Employee employee : employees) {
            if (employee.getAge() > limitAge) employee.printInfo();
        }
    }
}
