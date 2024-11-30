package ru.khusyainov.gb.java1.hw6;

import java.util.Arrays;
import java.util.Random;

public class HomeWork6 {
    static Number[] dogsMinimumLimits = {300, 0.3f, 8};
    static Number[] catsMinimumLimits = {100, 1.8f, 1};
    static Number[] dogsCatsLimitsDispersion = {300, 0.5f, 3};
    static Random random = new Random();
    static int animalsLimit = 10;
    static int testsLimit = 5;

    public static void main(String[] args) {
        int dogsCount = random.nextInt(animalsLimit) + 1;
        int catsCount = random.nextInt(animalsLimit) + 1;
        Dog[] dogs = new Dog[dogsCount];
        Cat[] cats = new Cat[catsCount];
        System.out.println(dogsCount + " dogs creating: ");
        int runDistance;
        float jumpHeight;
        int swimDistance;
        for (int i = 0; i < dogsCount; i++) {
            runDistance = getIntegerRandom(dogsMinimumLimits, AnimalLimitsType.RUN);
            jumpHeight = getFloatRandom(dogsMinimumLimits);
            swimDistance = getIntegerRandom(dogsMinimumLimits, AnimalLimitsType.SWIM);
            dogs[i] = new Dog("Dog " + (i + 1), runDistance, jumpHeight, swimDistance);
            dogs[i].printInfo();
        }
        System.out.println("\nDogs testing:");
        int testsCount = random.nextInt(testsLimit) + 1;
        for (int i = 0; i < testsCount; i++) {
            runDistance = getIntegerRandom(dogsMinimumLimits, AnimalLimitsType.RUN);
            jumpHeight = getFloatRandom(dogsMinimumLimits);
            swimDistance = getIntegerRandom(dogsMinimumLimits, AnimalLimitsType.SWIM);
            testAnimals(dogs, runDistance, jumpHeight, swimDistance);
        }
        System.out.println("\n\n" + catsCount + " cats creating:");
        for (int i = 0; i < catsCount; i++) {
            runDistance = getIntegerRandom(dogsMinimumLimits, AnimalLimitsType.RUN);
            jumpHeight = getFloatRandom(dogsMinimumLimits);
            swimDistance = getIntegerRandom(dogsMinimumLimits, AnimalLimitsType.SWIM);
            cats[i] = new Cat("Cat " + (i + 1), runDistance, jumpHeight, swimDistance);
            cats[i].printInfo();
        }
        System.out.println("\nCats testing:");
        testsCount = random.nextInt(testsLimit) + 1;
        for (int i = 0; i < testsCount; i++) {
            runDistance = getIntegerRandom(dogsMinimumLimits, AnimalLimitsType.RUN);
            jumpHeight = getFloatRandom(dogsMinimumLimits);
            swimDistance = getIntegerRandom(dogsMinimumLimits, AnimalLimitsType.SWIM);
            testAnimals(cats, runDistance, jumpHeight, swimDistance);
        }
    }

    static void testAnimals(Animal[] animals, int runDistance, float jumpHeight, int swimDistance) {
        System.out.println("\tRunning " + runDistance + ":");
        Arrays.stream(animals).forEach(animal -> animal.run(runDistance));
        System.out.println("\tJumping " + jumpHeight + ":");
        Arrays.stream(animals).forEach(animal -> animal.jump(jumpHeight));
        System.out.println("\tSwimming " + swimDistance + ":");
        Arrays.stream(animals).forEach(animal -> animal.swim(swimDistance));
    }

    static int getIntegerRandom(Number[] animalMinimumLimits, AnimalLimitsType animalLimitsType) {
        int limitIndex = animalLimitsType.ordinal();
        return animalMinimumLimits[limitIndex].intValue() +
                random.nextInt(dogsCatsLimitsDispersion[limitIndex].intValue());
    }

    static float getFloatRandom(Number[] animalMinimumLimits) {
        int limitIndex = AnimalLimitsType.JUMP.ordinal();
        return animalMinimumLimits[limitIndex].floatValue() +
                random.nextFloat(dogsCatsLimitsDispersion[limitIndex].floatValue());
    }
}
