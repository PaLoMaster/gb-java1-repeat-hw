package ru.khusyainov.gb.java1.hw5.spaceport.area.parts;

public class Door {
    private final float height;
    private final float width;
    private final float thickness;
    private float openness;
    private boolean hasLock;
    private Lock lock;

    public Door(float height, float width, float thickness) {
        this(height, width, thickness, null);
    }

    public Door(float height, float width, float thickness, Lock lock) {
        this.height = height;
        this.width = width;
        this.thickness = thickness;
        hasLock = lock != null;
        this.lock = lock;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getThickness() {
        return thickness;
    }

    public float getOpenness() {
        return openness;
    }

    public boolean isOpened() {
        return openness != 0;
    }

    public void setOpenness(float openness) {
        if (lock != null && !lock.isLocked()) {
            this.openness = openness;
            System.out.println("Дверь открыта на " + openness);
        } else {
            System.out.println("Дверь закрыта.");
        }
    }

    public boolean hasLock() {
        return hasLock;
    }

    public void changeLock(Lock lock) {
        hasLock = lock != null;
        this.lock = lock;
        lock.setDoor(this);
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Door{" +
                "height=" + height +
                ", width=" + width +
                ", thickness=" + thickness +
                ", openness=" + openness +
                ", hasLock=" + hasLock +
                (lock != null ? ", lock=" + lock : "") +
                '}';
    }
}
