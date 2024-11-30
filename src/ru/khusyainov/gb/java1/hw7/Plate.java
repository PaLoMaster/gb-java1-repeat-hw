package ru.khusyainov.gb.java1.hw7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int eatFood(int n) {
        int eaten = n <= food ? n : 0;
        food -= eaten;
        return eaten;
    }

    public void addFood(int n) {
        food += n;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}

