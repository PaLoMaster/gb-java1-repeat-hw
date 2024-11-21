package ru.khusyainov.gb.java1.hw5.spaceport.area.parts;

public class Window {
    private float height;
    private float width;
    private boolean opened;

    public Window(float height, float width) {
        this.height = height;
        this.width = width;
        opened = false;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public boolean isOpened() {
        return opened;
    }

    private boolean setOpened(boolean opened) {
        this.opened = opened;
        System.out.println("Окно " + (opened ? "от" : "за") + "крыто.");
        return opened;
    }

    public boolean open() {
        return setOpened(true);
    }

    public boolean close() {
        return setOpened(false);
    }

    @Override
    public String toString() {
        return "Window{" +
                "height=" + height +
                ", width=" + width +
                ", opened=" + opened +
                '}';
    }
}
