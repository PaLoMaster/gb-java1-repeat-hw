package ru.khusyainov.gb.java1.hw2;

import java.util.Arrays;
import java.util.OptionalInt;

public class HomeWork2 {
    public static void main(String[] args) {
        printArrayAndInverted(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0});

        System.out.println();

        printNewFilledArray();

        System.out.println();

        printNewArrayAndMultipliedByTwo();

        System.out.println();

        printNewArrayFilledByDiagonals(3);
        printNewArrayFilledByDiagonals(6);
        printNewArrayFilledByDiagonals(7);

        System.out.println();

        printMinimumMaximum(new int[]{0, 3, 6, 9, 12, 15, 18, 21});
        printMinimumMaximum(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});

        System.out.println();

        printArrayAndCheckBalance(new int[]{1, 1, 1, 2, 1});
        printArrayAndCheckBalance(new int[]{2, 1, 1, 2, 1});
        printArrayAndCheckBalance(new int[]{10, 10});
        printArrayAndCheckBalance(new int[]{5, 5, 5, 5, 10});
        printArrayAndCheckBalance(new int[]{10, 5, 5, 5, 10});
        printArrayAndCheckBalance(new int[]{10, 5, 5, 5, 25});
        printArrayAndCheckBalance(new int[]{10, 5, 5, 5, 10, 5});
        printArrayAndCheckBalance(new int[]{7, 8, 55, 55, 10, 5});
        printArrayAndCheckBalance(new int[]{8, 8, 54, 55, 10, 5});
        System.out.println("\tПримеры с граничными значениями Integer и багами:\n");
        printArrayAndCheckBalance(new int[]{2147483647, 2147483647});
        printArrayAndCheckBalance(new int[]{2147483647, 5, 2147483637, 15});
        printArrayAndCheckBalance(new int[]{2147483647, 10, -2147483639});
        System.out.println(Integer.MAX_VALUE + " - Integer.MAX_VALUE");

        System.out.println();

        printArrayAndShifted(new int[]{0, 3, 6, 9, 12, 15, 18, 21}, 7);
        printArrayAndShifted(new int[]{0, 3, 6, 9, 12, 15, 18, 21}, -3);
        printArrayAndShifted(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}, 4);
        printArrayAndShifted(new int[]{7, 8, 55, 55, 10, 5}, 2);
        printArrayAndShifted(new int[]{7, 8, 55, 55, 10, 5}, -4);
    }

    /**
     * Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
     * [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0.
     */
    public static void invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
    }

    /**
     * Вывод в консоль массивов: исходного и обновлённого методом {@link #invertArray(int[])}.
     */
    public static void printArrayAndInverted(int[] arr) {
        System.out.println("Original array: " + Arrays.toString(arr));
        invertArray(arr);
        System.out.println("Inverted array: " + Arrays.toString(arr));
    }

    /**
     * Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями
     * 0 3 6 9 12 15 18 21.
     */
    public static void printNewFilledArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println("Created and filled array: " + Arrays.toString(arr));
        System.out.println("\t\tBased on experience, it " +
                (Arrays.equals(arr, new int[]{0, 3, 6, 9, 12, 15, 18, 21}) ? "" : "not ") +
                "fits what was needed.");
    }

    /**
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
     * и числа меньшие 6 умножить на 2.
     */
    public static void printNewArrayAndMultipliedByTwo() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Original array: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println("Modified array: " + Arrays.toString(arr));
        System.out.println("\t\tValues less than 6 were multiplied by 2.");
    }

    /**
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов
     * одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами.
     */
    public static void printNewArrayFilledByDiagonals(int dimension) {
        int[][] arr = new int[dimension][dimension];
        for (int i = 0, j = dimension - 1; i < dimension; i++, j--) {
            arr[i][i] = 1;
            arr[i][j] = 1; // также можно обойтись одной переменной цикла: arr[i][dimension - i - 1] = 1
        }
        System.out.println("Filled by diagonals array of " + dimension + " rows and columns:");
        printTwoDimensionalArrayAsTable(arr);
    }

    /**
     * Вывод двумерного массива в консоль в виде таблицы.
     */
    private static void printTwoDimensionalArrayAsTable(int[][] arr) {
        Arrays.stream(arr).forEach(ints -> System.out.println(Arrays.toString(ints)));
    }

    /**
     * ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета).
     */
    public static void printMinimumMaximum(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//        min = max = arr[0]; // - version from 2018
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }
        }
        System.out.println("Minimum value is " + min + ", maximum value is " + max + ". Original array: " +
                Arrays.toString(arr));
        OptionalInt optionalMin = Arrays.stream(arr).min();
        if (optionalMin.isPresent()) {
            System.out.println("\t\tBased on experience, it's " +
                    (min == optionalMin.getAsInt() && max == Arrays.stream(arr).max().getAsInt() ? "" : "not ") +
                    "correct.");
        }
    }

    /**
     * ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод
     * должен вернуть true, если в массиве есть место, где сумма левой и правой части массива равны.
     * Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
     * checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
     * Первый вариант - с подсчётом сумм левой и правой частей.
     */
    public static boolean checkBalanceFirstVariant(int[] arr) {
        int sumRight = 0, sumLeft = 0;
        for (int i = 0, j = arr.length; i < j; i++) {
            sumLeft += arr[i];
            while (i < j && sumRight < sumLeft) {
                sumRight += arr[--j];
            }
            if (i == j) {
                return false;
            }
            if (sumLeft == sumRight) {
                sumLeft = sumRight = 0;
            }
        }
        return sumLeft == sumRight;
    }

    /**
     * ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод
     * должен вернуть true, если в массиве есть место, где сумма левой и правой части массива равны.
     * Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
     * checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
     * Второй вариант - с подсчётом разницы левой и правой частей (безопаснее, т.к. уменьшает
     * вероятность переполнения сумм левой/правой частей). При значениях, близких к граничным баг возможен,
     * например: [2147483647, 10, -2147483639] → true. Т.к. учебное, то не стал дальше заморачиваться.
     */
    public static boolean checkBalanceSecondVariant(int[] arr) {
        int difference = 0;
        for (int i = 0, j = arr.length - 1; i < j; ) {
            while (i < j && difference <= 0) {
                difference += arr[i++];
            }
            while (i < j && difference > 0) {
                difference -= arr[j--];
            }
            if (i == j) {
                if (difference < 0) {
                    return difference + arr[i] == 0;
                } else if (difference > 0) {
                    return difference - arr[j] == 0;
                } else {
                    return false;
                }
            }
        }
        return difference == 0;
    }

    /**
     * ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод
     * должен вернуть true, если в массиве есть место, где сумма левой и правой части массива равны.
     * Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
     * checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
     * Нулевой вариант - слегка подрихтованный с выполнения при первичном обучении в 2018ом году.
     */
    public static boolean checkBalanceZeroVariant(int[] arr) {
        int leftCount = 0;
        int rightCount = arr.length - 1;
        int sumLeft = arr[leftCount];
        int sumRight = arr[rightCount];
        while (leftCount + 1 < rightCount) {
            if (sumLeft < sumRight) {
                while (sumLeft < sumRight && leftCount + 1 < rightCount) {
                    sumLeft += arr[++leftCount];
                }
            } else if (sumLeft == sumRight && leftCount + 1 < rightCount - 1) {
                sumLeft += arr[++leftCount];
                sumRight += arr[--rightCount];
            } else {
                while (sumLeft > sumRight && leftCount + 1 < rightCount) {
                    sumRight += arr[--rightCount];
                }
            }
            if (leftCount + 1 == rightCount - 1) {
                leftCount = --rightCount;
                break;
            }
        }
        if (leftCount == rightCount)
            return (sumLeft + arr[leftCount] == sumRight || sumLeft == sumRight + arr[rightCount]);
        return sumLeft == sumRight;
    }

    /**
     * Вывод в консоль массива и заключения по сбалансированности из методов {@link #checkBalanceFirstVariant(int[])},
     * {@link #checkBalanceSecondVariant(int[])} и {@link #checkBalanceZeroVariant(int[])}.
     */
    public static void printArrayAndCheckBalance(int[] arr) {
        System.out.println("Array is " + (checkBalanceFirstVariant(arr) ? "" : "not ") + "balanced: " +
                Arrays.toString(arr) + " (first variant of method).");
        System.out.println("Array is " + (checkBalanceSecondVariant(arr) ? "" : "not ") + "balanced: " +
                Arrays.toString(arr) + " (second variant of method).");
        System.out.println("Array is " + (checkBalanceZeroVariant(arr) ? "" : "not ") + "balanced: " +
                Arrays.toString(arr) + " (zero variant of method - modernized version from 2018).");
        System.out.println();
    }

    /**
     * **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
     * или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Для усложнения
     * задачи нельзя пользоваться вспомогательными массивами.
     * Первый вариант - байтовый сдвиг при обмене элементами.
     */
    public static void shiftArrayElementsFirstVariant(int[] arr, int toPositions) {
        if (toPositions == 0) {
            return;
        }
        if (toPositions > arr.length / 2) {
            toPositions = toPositions - arr.length;
        }
        int direction = Integer.signum(toPositions);
        toPositions *= direction;
        for (int i = 0; i < arr.length - 1; i++) {
            int j = (arr.length - direction) % arr.length + (direction > 0 ? 0 : i);
            arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
        }
        if (toPositions > 1) {
            shiftArrayElementsFirstVariant(arr, --toPositions * direction);
        }
    }

    /**
     * **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
     * или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Для усложнения
     * задачи нельзя пользоваться вспомогательными массивами.
     * Второй (запрещённый) вариант (скорее для проверки остальных вариантов) - с помощью вспомогательного
     * массива, в который копируется исходный и затем возвращается уже со сдвигом.
     */
    public static void shiftArrayElementsSecondVariant(int[] arr, int toPositions) {
        int[] originalCopy = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            arr[(arr.length + i + toPositions) % arr.length] = originalCopy[i];
        }
    }

    /**
     * **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
     * или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Для усложнения
     * задачи нельзя пользоваться вспомогательными массивами.
     * Нулевой вариант (слегка подрихтованный с выполнения при первичном обучении в 2018ом году) - в двух
     * циклах, без рекурсии.
     */
    public static void shiftArrayElementsZeroVariant(int[] arr, int toPositions) {
        if (toPositions > arr.length) {
            toPositions %= arr.length;
        }
        if (toPositions == 0) {
            return;
        }
        int currentShift, buffer, firstElement, lastElement, direction;
        currentShift = 0;
        if (toPositions > 0) {
            firstElement = arr.length - 1;
            lastElement = 0;
            direction = -1;
        } else {
            firstElement = 0;
            lastElement = arr.length - 1;
            direction = 1;
        }
        while ((toPositions > 0) ? (++currentShift <= toPositions) : (--currentShift >= toPositions)) {
            for (int i = firstElement; (toPositions > 0) ? (i > lastElement) : (i < lastElement); i += direction) {
                buffer = arr[i + direction];
                arr[i + direction] = arr[i];
                arr[i] = buffer;
            }
        }
    }

    /**
     * Вывод в консоль массива и заключения по сбалансированности из методов
     * {@link #shiftArrayElementsFirstVariant(int[], int)}
     */
    public static void printArrayAndShifted(int[] arr, int toPosition) {
        System.out.println("Original array: " + Arrays.toString(arr));
        int[] shiftedArray = Arrays.copyOf(arr, arr.length);
        shiftArrayElementsFirstVariant(shiftedArray, toPosition);
        System.out.println("Shifted array:  " + Arrays.toString(shiftedArray) + " to " + toPosition
                + " positions (first variant).");
        shiftedArray = Arrays.copyOf(arr, arr.length);
        shiftArrayElementsSecondVariant(shiftedArray, toPosition);
        System.out.println("Shifted array:  " + Arrays.toString(shiftedArray) + " to " + toPosition
                + " positions (second variant).");
        shiftedArray = Arrays.copyOf(arr, arr.length);
        shiftArrayElementsZeroVariant(shiftedArray, toPosition);
        System.out.println("Shifted array:  " + Arrays.toString(shiftedArray) + " to " + toPosition
                + " positions (zero variant - modernized version from 2018).");
        System.out.println();
    }
}
