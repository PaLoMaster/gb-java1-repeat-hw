package ru.khusyainov.gb.java1.hw6;

import java.util.Random;

public class HomeWork6 {
    enum Limits {
        RUN,
        JUMP,
        SWIM
    }

    static Number[] dogsMinimumLimits = {300, 0.3f, 8};
    static Number[] catsMinimumLimits = {100, 1.8f, 1};
    static Number[] dogsCatsLimitSteps = {50, 0.1f, 1};
    static int[] dogsCatsLimitStepsCounts = {6, 5, 3};
    static Random random = new Random();
    static int animalsLimit = 10;
    static int testsLimit = 5;

    public static void main(String[] args) {
        int dogsCount = random.nextInt(animalsLimit) + 1;
        int catsCount = random.nextInt(animalsLimit) + 1;
        Dog[] dogs = new Dog[dogsCount];
        Cat[] cats = new Cat[catsCount];
        System.out.println(dogsCount + " dogs creating: ");
        for (int i = 0; i < dogsCount; i++) {
            dogs[i] = new Dog("Dog " + (i + 1), getDogsRandomRunDistance(), getDogsRandomJumpHeight(),
                    getDogsRandomSwimDistance());
            dogs[i].printInfo();
        }
        System.out.println("\nDogs testing:");
        int testsCount = random.nextInt(testsLimit);
        for (int i = 0; i < testsCount; i++) {
            testAnimals(dogs, getDogsRandomRunDistance(), getDogsRandomJumpHeight(), getDogsRandomSwimDistance());
        }
        System.out.println("\n\n" + catsCount + " cats creating:");
        for (int i = 0; i < catsCount; i++) {
            cats[i] = new Cat("Cat " + (i + 1), getCatsRandomRunDistance(), getCatsRandomJumpHeight(),
                    getCatsRandomSwimDistance());
            cats[i].printInfo();
        }
        System.out.println("\nCats testing:");
        testAnimals(cats, getCatsRandomRunDistance(), getCatsRandomJumpHeight(), getCatsRandomSwimDistance());
    }

    static void testAnimals(Animal[] animals, int runDistance, float jumpHeight, int swimDistance) {
        System.out.println("\tRunning " + runDistance + ", jumping " + jumpHeight + ", swimming " + swimDistance + ":");
        for (Animal animal : animals) {
            animal.run(runDistance);
            animal.jump(jumpHeight);
            animal.swim(swimDistance);
        }
    }

    private static int getRandomRunDistance(int minimum, int limitsIndex) {
        return minimum + dogsCatsLimitSteps[limitsIndex].intValue() *
                random.nextInt(dogsCatsLimitStepsCounts[limitsIndex]);
    }

    private static int getDogsRandomRunDistance() {
        int limitsIndex = Limits.RUN.ordinal();
        return getRandomRunDistance(dogsMinimumLimits[limitsIndex].intValue(), limitsIndex);
    }

    private static int getCatsRandomRunDistance() {
        int limitsIndex = Limits.RUN.ordinal();
        return getRandomRunDistance(catsMinimumLimits[limitsIndex].intValue(), limitsIndex);
    }

    private static float getRandomJumpHeight(float minimum, int limitsIndex) {
        return minimum + dogsCatsLimitSteps[limitsIndex].floatValue() *
                random.nextInt(dogsCatsLimitStepsCounts[limitsIndex]);
    }

    private static float getDogsRandomJumpHeight() {
        int limitsIndex = Limits.JUMP.ordinal();
        return getRandomJumpHeight(dogsMinimumLimits[limitsIndex].floatValue(), limitsIndex);
    }

    private static float getCatsRandomJumpHeight() {
        int limitsIndex = Limits.JUMP.ordinal();
        return getRandomJumpHeight(catsMinimumLimits[limitsIndex].floatValue(), limitsIndex);
    }

    private static int getRandomSwimDistance(int minimum, int limitsIndex) {
        return minimum + dogsCatsLimitSteps[limitsIndex].intValue() *
                random.nextInt(dogsCatsLimitStepsCounts[limitsIndex]);
    }

    private static int getDogsRandomSwimDistance() {
        int limitsIndex = Limits.SWIM.ordinal();
        return getRandomSwimDistance(dogsMinimumLimits[limitsIndex].intValue(), limitsIndex);
    }

    private static int getCatsRandomSwimDistance() {
        int limitsIndex = Limits.SWIM.ordinal();
        return getRandomSwimDistance(catsMinimumLimits[limitsIndex].intValue(), limitsIndex);
    }
}
