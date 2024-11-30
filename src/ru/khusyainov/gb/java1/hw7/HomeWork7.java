package ru.khusyainov.gb.java1.hw7;

import java.util.Random;

public class HomeWork7 {
    public static void main(String[] args) {
        Random random = new Random();
        int catsCount = random.nextInt(1, 11);
        Cat[] cats = new Cat[catsCount];
        int catsMaximumAppetite = 16;
        System.out.println("Creating cats:");
        for (int i = 0; i < catsCount; i++) {
            cats[i] = new Cat("Cat " + (i + 1), random.nextInt(1, catsMaximumAppetite));
            System.out.println(cats[i]);
        }
        int randomPlateFullness = random.nextInt(catsMaximumAppetite, catsMaximumAppetite * (catsCount - 1));
        Plate plate = new Plate(randomPlateFullness);
        System.out.println("\n" + plate + "\n\nFeeding cats:");
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.showSatiety();
        }
        System.out.println("\n" + plate + "\n");
        plate.addFood(randomPlateFullness);
        System.out.println("After adding " + randomPlateFullness + " food:\n" + plate + "\n");
    }
}
