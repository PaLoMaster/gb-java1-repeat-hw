package ru.khusyainov.gb.java1.hw1;

public class HomeWork1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        System.out.println();

        primitivesInitialization();

        System.out.println();

        int a = 1, b = 5, c = 27, d = 9;
        printResultOfThirdTask(a, b, c, d);
        c = 20;
        d = 19;
        printResultOfThirdTask(a, b, c, d);
        System.out.println("\t\tIt's because of rounding to integers.");
        printResultOfThirdTaskFloat(a, b, c, d);
        System.out.println("\t\tIt's more precisely - rounding to float.");

        System.out.println();

        printIsSumWithin10And20(a, b);
        d = 15;
        printIsSumWithin10And20(a, d);
        printIsSumWithin10And20(c, d);
        d = -150;
        printIsSumWithin10And20(c, d);

        System.out.println();

        printIsPositiveOrNegativeOrZero(a);
        printIsPositiveOrNegativeOrZero(b);
        printIsPositiveOrNegativeOrZero(d);
        printIsPositiveOrNegativeOrZero(0);

        System.out.println();

        printIsNegative(a);
        printIsNegative(b);
        printIsNegative(d);
        printIsNegative(0);

        System.out.println();

        printHiTo("Антон");
        printHiTo("Айрат");
        printHiTo("Альбина");

        System.out.println();

        printCheckOnLeapYear(1991);
        printCheckOnLeapYear(2000);
        printCheckOnLeapYear(2001);
        printCheckOnLeapYear(2002);
        printCheckOnLeapYear(2024);
        printCheckOnLeapYear(2100);
    }

    /**
     * Создать переменные всех пройденных типов данных, и инициализировать их значения.
     */
    public static void primitivesInitialization() {
        byte byteValueMaximum = 127;
        byte byteValueMinimum = -128;
        byte byteValue1 = 15;
        byte byteValue2 = 99;
        byte byteValue3 = 75;
        System.out.println("Maximum byte value: " + byteValueMaximum + " (by value in class code).");
        System.out.println("Maximum byte value: " + Byte.MAX_VALUE + " (by global constant Byte.MAX_VALUE).");
        System.out.println("Minimum byte value: " + byteValueMinimum + " (by value in class code).");
        System.out.println("Minimum byte value: " + Byte.MIN_VALUE + " (by global constant Byte.MIN_VALUE).");
        System.out.println("One of byte values: " + byteValue1 + ", " + byteValue2 + ", " + byteValue3);

        System.out.println();

        short shortValueMaximum = 32767;
        short shortValueMinimum = -32768;
        short shortValue1 = 15;
        short shortValue2 = 999;
        short shortValue3 = 756;
        System.out.println("Maximum short value: " + shortValueMaximum + " (by value in class code).");
        System.out.println("Maximum short value: " + Short.MAX_VALUE + " (by global constant Short.MAX_VALUE).");
        System.out.println("Minimum short value: " + shortValueMinimum + " (by value in class code).");
        System.out.println("Minimum short value: " + Short.MIN_VALUE + " (by global constant Short.MIN_VALUE).");
        System.out.println("One of short values: " + shortValue1 + ", " + shortValue2 + ", " + shortValue3);

        System.out.println();

        int intValueMaximum = 2147483647;
        int intValueMinimum = -2147483648;
        int intValue1 = 15;
        int intValue2 = 99999;
        int intValue3 = 75635;
        System.out.println("Maximum int value: " + intValueMaximum + " (by value in class code).");
        System.out.println("Maximum int value: " + Integer.MAX_VALUE + " (by global constant Integer.MAX_VALUE).");
        System.out.println("Minimum int value: " + intValueMinimum + " (by value in class code).");
        System.out.println("Minimum int value: " + Integer.MIN_VALUE + " (by global constant Integer.MIN_VALUE).");
        System.out.println("One of int values: " + intValue1 + ", " + intValue2 + ", " + intValue3);

        System.out.println();

        long longValueMaximum = 9223372036854775807L;
        long longValueMinimum = -9223372036854775808L;
        long longValue1 = 15L;
        long longValue2 = 9999999999L;
        long longValue3 = 7323654585L;
        System.out.println("Maximum long value: " + longValueMaximum + " (by value in class code).");
        System.out.println("Maximum long value: " + Long.MAX_VALUE + " (by global constant Long.MAX_VALUE).");
        System.out.println("Minimum long value: " + longValueMinimum + " (by value in class code).");
        System.out.println("Minimum long value: " + Long.MIN_VALUE + " (by global constant Long.MIN_VALUE).");
        System.out.println("One of long values: " + longValue1 + ", " + longValue2 + ", " + longValue3);

        System.out.println();

        float floatValueMaximum = 3.4028235E38F;
        float floatValueMinimum = 1.4E-45F;
        float floatValue1 = 15F;
        float floatValue2 = 9.99F;
        float floatValue3 = 1934911620F;
        System.out.println("Maximum float value: " + floatValueMaximum + " (by value in class code).");
        System.out.println("Maximum float value: " + Float.MAX_VALUE + " (by global constant Float.MAX_VALUE).");
        System.out.println("Minimum float value: " + floatValueMinimum + " (by value in class code).");
        System.out.println("Minimum float value: " + Float.MIN_VALUE + " (by global constant Float.MIN_VALUE).");
        System.out.println("One of float values: " + floatValue1 + ", " + floatValue2 + ", " + floatValue3);

        System.out.println();

        double doubleValueMaximum = 1.7976931348623157E308;
        double doubleValueMinimum = 4.9E-324;
        double doubleValue1 = 15;
        double doubleValue2 = 9.9999999999;
        double doubleValue3 = 1416131670;
        System.out.println("Maximum double value: " + doubleValueMaximum + " (by value in class code).");
        System.out.println("Maximum double value: " + Double.MAX_VALUE + " (by global constant Double.MAX_VALUE).");
        System.out.println("Minimum double value: " + doubleValueMinimum + " (by value in class code).");
        System.out.println("Minimum double value: " + Double.MIN_VALUE + " (by global constant Double.MIN_VALUE).");
        System.out.println("One of double values: " + doubleValue1 + ", " + doubleValue2 + ", " + doubleValue3);

        System.out.println();

        char charValueMaximum = 65535;
        char charValueMinimum = 0;
        char charValue1 = 15;
        char charValue2 = 'ш';
        char charValue3 = 't';
        System.out.println("Maximum char value: " + charValueMaximum + " (by value in class code).");
        System.out.println("Maximum char value: " + Character.MAX_VALUE + " (by global constant Character.MAX_VALUE).");
        System.out.println("Minimum char value: " + charValueMinimum + " (by value in class code).");
        System.out.println("Minimum char value: " + Character.MIN_VALUE + " (by global constant Character.MIN_VALUE).");
        System.out.println("One of char values: " + charValue1 + ", " + charValue2 + ", " + charValue3);

        System.out.println();

        boolean booleanValueFirst = true;
        boolean booleanValueSecondLast = false;
        System.out.println("First boolean value: " + booleanValueFirst + " (by value in class code).");
        System.out.println("First boolean value: " + Boolean.TRUE + " (by global constant Boolean.TRUE).");
        System.out.println("Second and last boolean value: " + booleanValueSecondLast + " (by value in class code).");
        System.out.println("Second and last boolean value: " + Boolean.FALSE + " (by global constant Boolean.FALSE).");
        System.out.println("There are no other boolean values.");
    }

    /**
     * Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     * где a, b, c, d – входные параметры этого метода.
     *
     * @return Целочисленный результат выражения a * (b + (c / d)).
     */
    public static int thirdTask(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    /**
     * {@link #thirdTask(int, int, int, int)}.
     *
     * @return Результат выражения a * (b + (c / d)) с типом float.
     */
    public static float thirdTaskFloat(int a, int b, int c, int d) {
        return a * (b + ((float) c / d));
    }

    /**
     * Вывод в консоль формулы с подставленными входными значения и результатом метода
     * {@link #thirdTask(int, int, int, int)}.
     */
    private static void printResultOfThirdTask(int a, int b, int c, int d) {
        System.out.println(a + " * (" + b + " + (" + c + " / " + d + ")) = " + thirdTask(a, b, c, d) + ".");
    }

    /**
     * Вывод в консоль формулы с подставленными входными значения и результатом метода
     * {@link #thirdTaskFloat(int, int, int, int)}.
     */
    public static void printResultOfThirdTaskFloat(int a, int b, int c, int d) {
        System.out.println(a + " * (" + b + " + (" + c + " / " + d + ")) = " + thirdTaskFloat(a, b, c, d) + ".");
    }

    /**
     * Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах
     * от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     * @return True, если 10 <= a + b <= 20. Иначе - false.
     */
    public static boolean isSumWithin10And20(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    /**
     * Вывод в консоль формулы с подставленными значениями входных параметров и заключением
     * по результату метода {@link #isSumWithin10And20(int, int)}.
     */
    public static void printIsSumWithin10And20(int a, int b) {
        System.out.println("The sum of " + a + " and " + b + " ( =" + (a + b) + " ) " + (isSumWithin10And20(a, b) ? "" : "not ") +
                "lies between 10 and to 20.");
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
     * положительное ли число передали, или отрицательное. Если передать ноль, то вывести "Введён 0".
     */
    public static void printIsPositiveOrNegativeOrZero(int a) {
        if (a == 0) {
            System.out.println("Transferred 0.");
        } else if (a < 0) {
            System.out.println("Negative number passed: " + a);
        } else {
            System.out.println("Non-negative number passed: " + a);
        }
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
     * если число отрицательное.
     * @return True, если число отрицательное. Иначе - false.
     */
    public static boolean isNegative(int a) {
        return a < 0;
    }

    /**
     * Вывод в консоль описание результата метода {@link #isNegative(int)}.
     */
    public static void printIsNegative(int a) {
        System.out.println((isNegative(a) ? "N" : "Non-n") + "egative number: " + a);
    }

    /**
     * Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен
     * вывести в консоль сообщение «Привет, указанное_имя!».
     */
    public static void printHiTo(String toName) {
        System.out.println("Привет, " + toName + "!");
    }

    /**
     * * Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static void printCheckOnLeapYear(int year) {
        System.out.println(year + " is " +
                (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ? "" : "not ") +
                "a leap year");
    }
}