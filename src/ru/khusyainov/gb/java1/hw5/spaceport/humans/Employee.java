package ru.khusyainov.gb.java1.hw5.spaceport.humans;

public class Employee {
    private String name;
    private String role;
    private String sex;
    private boolean atWork;
    private float weight;

    public Employee(String name, String role, String sex, boolean atWork, float weight) {
        this.name = name;
        this.role = role;
        this.sex = sex;
        this.atWork = atWork;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public boolean isAtWork() {
        return atWork;
    }

    public void setAtWork(boolean atWork) {
        this.atWork = atWork;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", sex='" + sex + '\'' +
                ", atWork=" + atWork +
                ", weight=" + weight +
                '}';
    }
}
