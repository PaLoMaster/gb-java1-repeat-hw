package ru.khusyainov.gb.java1.hw6;

public abstract class Animal {
    String name;
    int maxRunDistance;
    float maxJumpHeight;
    int maxSwimDistance;

    public Animal(String name, int maxRunDistance, float maxJumpHeight, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
    }

    private <T extends Comparable<T>> void executor(T executionLimit, T executionRate, String executionDescriptor) {
        String pattern = "%s named as \"%s\", can %5$s %s, must %s, %s: %b\n";
        if (executionLimit.compareTo(executionRate) >= 0) {
            System.out.printf(pattern, this.getClass().getSimpleName(), name, executionLimit, executionRate,
                    executionDescriptor, true);
        } else {
            System.out.printf(pattern, this.getClass().getSimpleName(), name, executionLimit, executionRate,
                    executionDescriptor, false);
        }
    }

    public void run(int runDistance) {
        executor(maxRunDistance, runDistance, "run");
    }

    public void jump(float jumpHeight) {
        executor(maxJumpHeight, jumpHeight, "jump");
    }

    public void swim(int swimDistance) {
        executor(maxSwimDistance, swimDistance, "swim");
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", maxRunDistance=" + maxRunDistance +
                ", maxJumpHeight=" + maxJumpHeight +
                ", maxSwimDistance=" + maxSwimDistance +
                '}';
    }
}
