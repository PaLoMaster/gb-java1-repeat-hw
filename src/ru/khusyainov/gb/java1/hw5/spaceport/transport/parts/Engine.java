package ru.khusyainov.gb.java1.hw5.spaceport.transport.parts;

public class Engine {
    private boolean started;

    public boolean isStarted() {
        return started;
    }

    private void setStarted(boolean started) {
        this.started = started;
    }

    public void start() {
        setStarted(true);
    }

    public void stop() {
        setStarted(false);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "started=" + started +
                '}';
    }
}
