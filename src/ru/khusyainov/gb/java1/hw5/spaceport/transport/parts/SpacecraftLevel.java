package ru.khusyainov.gb.java1.hw5.spaceport.transport.parts;

import ru.khusyainov.gb.java1.hw5.spaceport.humans.Employee;

import java.util.Arrays;

public class SpacecraftLevel {
    private int level;
    private final String task;
    private boolean activity;
    private final boolean hasCrewCabin;
    private Employee[] employees;
    private Engine engine;
    private SpacecraftSystem[] spacecraftSystems;

    public SpacecraftLevel(String task, boolean hasCrewCabin, Engine engine, SpacecraftSystem[] spacecraftSystems) {
        this.task = task;
        this.hasCrewCabin = hasCrewCabin;
        this.engine = engine;
        this.spacecraftSystems = spacecraftSystems;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTask() {
        return task;
    }

    public boolean isActive() {
        return activity;
    }

    private void setActivity(boolean activity) {
        this.activity = activity;
    }

    public void activate() {

    }

    public void deactivate() {

    }

    public boolean hasCrewCabin() {
        return hasCrewCabin;
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

    public SpacecraftSystem[] getSpacecraftSystems() {
        return spacecraftSystems;
    }

    public void changeAllSpacecraftSystems(SpacecraftSystem[] spacecraftSystems) {
        this.spacecraftSystems = spacecraftSystems;
    }

    public void addSpacecraftSystem(SpacecraftSystem spacecraftSystem) {

    }

    public void addSpacecraftSystems(SpacecraftSystem[] spacecraftSystems) {

    }

    public void removeSpacecraftSystem(SpacecraftSystem spacecraftSystem) {

    }

    public void removeSpacecraftSystems(SpacecraftSystem[] spacecraftSystems) {

    }

    @Override
    public String toString() {
        return "SpacecraftLevel{" +
                "level=" + level +
                ", task='" + task + '\'' +
                ", activity=" + activity +
                ", hasCrewCabin=" + hasCrewCabin +
                (employees != null ? ", employees=" + Arrays.toString(employees) : "") +
                ", engine=" + engine +
                ", spacecraftSystems=" + Arrays.toString(spacecraftSystems) +
                '}';
    }
}
