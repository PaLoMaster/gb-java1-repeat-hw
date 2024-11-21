package ru.khusyainov.gb.java1.hw5.spaceport.area.furniture;

public class Table {
    private float height;
    private float width;
    private float length;
    private float weight;

    public Table(float height, float width, float length, float weight) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.weight = weight;
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

    @Override
    public String toString() {
        return "Table{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", weight=" + weight +
                '}';
    }
}
