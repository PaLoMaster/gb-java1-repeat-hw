package ru.khusyainov.gb.java1.hw5.spaceport.area.furniture;

public class Chair {
    private float height;
    private float width;
    private float length;
    private float weight;
    private boolean busyness;

    public Chair(float height, float width, float length, float weight) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.weight = weight;
        busyness = false;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getLength() {
        return length;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isBusy() {
        return busyness;
    }

    public void setBusyness(boolean busyness) {
        this.busyness = busyness;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", weight=" + weight +
                ", busyness=" + busyness +
                '}';
    }
}
