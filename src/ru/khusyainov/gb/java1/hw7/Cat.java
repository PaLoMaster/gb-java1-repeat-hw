package ru.khusyainov.gb.java1.hw7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void eat(Plate p) {
        satiety = p.eatFood(appetite) == appetite;
    }

    public void showSatiety() {
        System.out.println("Cat with name \"" + name + "\" and appetite " + appetite +
                (satiety ? " well-fed." : " hungry."));
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}