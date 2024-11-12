package ru.khusyainov.gb.java1.hw1;

import java.util.Objects;

public class HomeWork1Extended {
    public static void main(String[] args) {
        byte byteValueMaximum = 127;
        byte byteValueMinimum = -128;
        showMinimumMaximum(byteValueMaximum, byteValueMinimum, Byte.MAX_VALUE, Byte.MIN_VALUE, "byte");

        short shortValueMaximum = 32767;
        short shortValueMinimum = -32768;
        showMinimumMaximum(shortValueMaximum, shortValueMinimum, Short.MAX_VALUE, Short.MIN_VALUE, "short");

        int intValueMaximum = 2147483647;
        int intValueMinimum = -2147483648;
        showMinimumMaximum(intValueMaximum, intValueMinimum, Integer.MAX_VALUE, Integer.MIN_VALUE, "int");

        long longValueMaximum = 9223372036854775807L;
        long longValueMinimum = -9223372036854775808L;
        showMinimumMaximum(longValueMaximum, longValueMinimum, Long.MAX_VALUE, Long.MIN_VALUE, "long");

        float floatValueMaximum = 3.4028235E38F;
        float floatValueMinimum = 1.4E-45F;
        showMinimumMaximum(floatValueMaximum, floatValueMinimum, Float.MAX_VALUE, Float.MIN_VALUE, "float");

        double doubleValueMaximum = 1.7976931348623157E308;
        double doubleValueMinimum = 4.9E-324;
        showMinimumMaximum(doubleValueMaximum, doubleValueMinimum, Double.MAX_VALUE, Double.MIN_VALUE, "double");

        char charValueMaximum = '\uFFFF';
        char charValueMinimum = '\u0000';
        showMinimumMaximum(charValueMaximum, charValueMinimum, Character.MAX_VALUE, Character.MIN_VALUE, "char");

        boolean booleanValueFirst = true;
        boolean booleanValueSecondLast = false;
        System.out.println("First boolean value: " + booleanValueFirst + " (by value in class code).");
        System.out.print("First boolean value: " + Boolean.TRUE + " (by global constant TRUE).");
        System.out.println(" Upper value is " + (booleanValueFirst == Boolean.TRUE ? "" : "not ") + "equal to global constant.");
        System.out.println("Second and last boolean value: " + booleanValueSecondLast + " (by value in class code).");
        System.out.print("Second and last boolean value: " + Boolean.FALSE + " (by global constant FALSE).");
        System.out.println(" Upper value is " + (booleanValueSecondLast == Boolean.FALSE ? "" : "not ") + "equal to global constant.");
    }

    private static <T> void showMinimumMaximum(T valueMaximumByCode, T valueMinimumByCode,
                                               T valueMaximumByClass, T valueMinimumByClass, String typeName) {
        System.out.println("Maximum " + typeName + " value: " + valueMaximumByCode + " (by value in class code).");
        System.out.println("Maximum " + typeName + " value: " + valueMaximumByClass + " (by global constant " +
                valueMaximumByClass.getClass().getSimpleName() + ".MAX_VALUE). Upper value is " +
                (Objects.equals(valueMaximumByCode, valueMaximumByClass) ? "" : "not ") +
                "equal to global constant.");
        System.out.println("Minimum " + typeName + " value: " + valueMinimumByCode + " (by value in class code).");
        System.out.println("Minimum " + typeName + " value: " + valueMinimumByClass + " (by global constant " +
                valueMinimumByClass.getClass().getSimpleName() + ".MIN_VALUE). Upper value is " +
                (Objects.equals(valueMinimumByCode, valueMinimumByClass) ? "" : "not ") +
                "equal to global constant.");
        System.out.println();
    }
}
