package ru.khusyainov.gb.java1.hw5.spaceport.transport.parts;

public class SpacecraftSystem {
    private final String task;
    private boolean working;

    public SpacecraftSystem(String task) {
        this.task = task;
        working = true;
    }

    public String getTask() {
        return task;
    }

    public boolean isWorking() {
        return working;
    }

    private void setWorking(boolean working) {
        this.working = working;
    }

    public void start() {

    }

    public void stop() {

    }

    private void selfDiagnose() {

    }

    @Override
    public String toString() {
        return "SpacecraftSystem{" +
                "task='" + task + '\'' +
                ", working=" + working +
                '}';
    }
}
