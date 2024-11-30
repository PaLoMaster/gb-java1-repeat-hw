package ru.khusyainov.gb.java1.hw6;

import java.lang.reflect.Array;
import java.util.Random;

public class HomeWork6Generic {
    static Number[] dogsMinimumLimits = HomeWork6.dogsMinimumLimits;
    static Number[] catsMinimumLimits = HomeWork6.catsMinimumLimits;
    static Number[] animalNullMinimumLimits = {0, 0, 0};
    static Random random = HomeWork6.random;
    static int animalsLimit = HomeWork6.animalsLimit;
    static int testsLimit = HomeWork6.testsLimit;

    public static void main(String[] args) {
        animalsCreatingAndTesting(Dog.class, AnimalType.DOG);
        System.out.println("\n\n");
        animalsCreatingAndTesting(Cat.class, AnimalType.CAT);
    }

    private static <T extends Animal> void animalsCreatingAndTesting(Class<T> tClass, AnimalType animalType) {
        int animalsCount = random.nextInt(animalsLimit) + 1;
        T[] animals = (T[]) Array.newInstance(tClass, animalsCount);
        int runDistance;
        float jumpHeight;
        int swimDistance;
        System.out.println(animalsCount + " " + animalType.name().toLowerCase() + "s creating:");
        for (int i = 0; i < animalsCount; i++) {
            T animal = null;
            String name = animalType.toUpperCamelCase() + " " + (i + 1);
            runDistance = getIntegerRandom(animalType, AnimalLimitsType.RUN);
            jumpHeight = getFloatRandom(animalType);
            swimDistance = getIntegerRandom(animalType, AnimalLimitsType.SWIM);
            switch (animalType) {
                case DOG -> animal = (T) new Dog(name, runDistance, jumpHeight, swimDistance);
                case CAT -> animal = (T) new Cat(name, runDistance, jumpHeight, swimDistance);
            }
            animals[i] = animal;
            animals[i].printInfo();
        }
        System.out.println("\n" + animalType.toUpperCamelCase() + "s testing:");
        int testsCount = random.nextInt(testsLimit);
        for (int i = 0; i < testsCount; i++) {
            runDistance = getIntegerRandom(animalType, AnimalLimitsType.RUN);
            jumpHeight = getFloatRandom(animalType);
            swimDistance = getIntegerRandom(animalType, AnimalLimitsType.SWIM);
            HomeWork6.testAnimals(animals, runDistance, jumpHeight, swimDistance);
        }
    }

    private static int getIntegerRandom(AnimalType animalType, AnimalLimitsType animalLimitsType) {
        Number[] animalMinimumLimits = animalNullMinimumLimits;
        switch (animalType) {
            case DOG -> animalMinimumLimits = dogsMinimumLimits;
            case CAT -> animalMinimumLimits = catsMinimumLimits;
        }
        return HomeWork6.getIntegerRandom(animalMinimumLimits, animalLimitsType);
    }

    private static float getFloatRandom(AnimalType animalType) {
        Number[] animalMinimumLimits = animalNullMinimumLimits;
        switch (animalType) {
            case DOG -> animalMinimumLimits = dogsMinimumLimits;
            case CAT -> animalMinimumLimits = catsMinimumLimits;
        }
        return HomeWork6.getFloatRandom(animalMinimumLimits);
    }
}
