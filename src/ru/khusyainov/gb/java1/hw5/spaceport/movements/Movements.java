package ru.khusyainov.gb.java1.hw5.spaceport.movements;

import java.util.*;

public class Movements {
    public static<T> T[] moveIn(T[] existing, T[] moving) {
        T[] result;
        if (existing == null) {
            result = moving;
        } else {
            result = Arrays.copyOf(existing, existing.length + moving.length);
            System.arraycopy(moving, 0, existing, existing.length, moving.length);
        }
        return result;
    }

    public static<T> T[] moveOut(T[] existing, T[] moving) {
        if ((existing == null && moving != null) || (existing != null && moving == null)) {
            return existing != null ? existing : moving;
        } else if (Arrays.equals(existing, moving)) {
            return null;
        }
        int elementsCount = 0;
        for (int i = 0; i < existing.length; i++) {
            for (T element : moving) {
                if (Objects.equals(element, existing[i])) {
                    existing[i] = null;
                    break;
                }
            }
            if (existing[i] != null) {
                elementsCount++;
            }
        }
        if (elementsCount == 0) {
            return null;
        }
        T[] result = (T[]) new Object[elementsCount];
        for (int i = 0, j = 0; i < existing.length; i++) {
            if (existing[i] != null) {
                result[j++] = existing[i];
            }
        }
        return result;
    }
}
