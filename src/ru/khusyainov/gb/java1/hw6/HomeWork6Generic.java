package ru.khusyainov.gb.java1.hw6;

import java.lang.reflect.Array;
import java.util.Random;

public class HomeWork6Generic {
    static Number[] dogsMinimumLimits = HomeWork6.dogsMinimumLimits;
    static Number[] catsMinimumLimits = HomeWork6.catsMinimumLimits;
    static Number[] dogsCatsLimitSteps = HomeWork6.dogsCatsLimitSteps;
    static int[] dogsCatsLimitStepsCounts = HomeWork6.dogsCatsLimitStepsCounts;
    static Random random = HomeWork6.random;
    static int animalsLimit = HomeWork6.animalsLimit;
    static int testsLimit = HomeWork6.testsLimit;

    enum AnimalType {
        DOG, CAT;

        String toUpperCamelCase() {
            StringBuilder builder = new StringBuilder();
            String[] words = this.name().split("[\\W_]+");
            for (String word : words) {
                word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) +
                        word.substring(1).toLowerCase();
                builder.append(word);
            }
            return builder.toString();
        }
    }

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
            runDistance = getRandomRunDistance(animalType);
            jumpHeight = getRandomJumpHeight(animalType);
            swimDistance = getRandomSwimDistance(animalType);
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
            runDistance = getRandomRunDistance(animalType);
            jumpHeight = getRandomJumpHeight(animalType);
            swimDistance = getRandomSwimDistance(animalType);
            HomeWork6.testAnimals(animals, runDistance, jumpHeight, swimDistance);
        }
    }

    private static int getIntegerRandomByLimits(AnimalType animalType, int limitsIndex) {
        int minimum = 0;
        switch (animalType) {
            case DOG -> minimum = dogsMinimumLimits[limitsIndex].intValue();
            case CAT -> minimum = catsMinimumLimits[limitsIndex].intValue();
        }
        return minimum + dogsCatsLimitSteps[limitsIndex].intValue() *
                random.nextInt(dogsCatsLimitStepsCounts[limitsIndex]);
    }

    private static int getRandomRunDistance(AnimalType animalType) {
        return getIntegerRandomByLimits(animalType, HomeWork6.Limits.RUN.ordinal());
    }

    private static float getRandomJumpHeight(AnimalType animalType) {
        float minimum = 0;
        int limitsIndex = HomeWork6.Limits.JUMP.ordinal();
        switch (animalType) {
            case DOG -> minimum = dogsMinimumLimits[limitsIndex].floatValue();
            case CAT -> minimum = catsMinimumLimits[limitsIndex].floatValue();
        }
        return minimum + dogsCatsLimitSteps[limitsIndex].floatValue() *
                random.nextInt(dogsCatsLimitStepsCounts[limitsIndex]);
    }

    private static int getRandomSwimDistance(AnimalType animalType) {
        return getIntegerRandomByLimits(animalType, HomeWork6.Limits.SWIM.ordinal());
    }
}
