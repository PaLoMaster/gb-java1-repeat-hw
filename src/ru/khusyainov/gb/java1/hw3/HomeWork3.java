package ru.khusyainov.gb.java1.hw3;

import java.util.*;

public class HomeWork3 {
    public static void main(String[] args) {
//        guessNumber();
        guessWord();
    }

    /**
     * Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки
     * угадать это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем
     * число чем загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру
     * еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */
    public static void guessNumber() {
        boolean repeat, canTry;
        int target, tryInt, tryCount;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        do {
            target = random.nextInt(10);
            System.out.println("Угадайте число от 0 до 9. У Вас 3 попытки.");
            tryCount = 1;
            canTry = true;
            do {
                tryInt = getIntFromScanner(scanner, "Введите число от 0 до 9: ");
                if (target == tryInt) {
                    System.out.print("Поздравляю! ");
                    canTry = false;
                } else if (target > tryInt) {
                    System.out.print("Загаданное число больше. ");
                } else {
                    System.out.print("Загаданное число меньше. ");
                }
                System.out.print((canTry ? "Неу" : "У") + "гадали" + (canTry ? "." : "!!!") + " Использовали " +
                        tryCount + " попытк" + (tryCount == 1 ? "у" : "и"));
                if (canTry) {
                    switch (tryCount) {
                        case 1 -> System.out.println(", осталось ещё 2!");
                        case 2 -> System.out.println(", осталась последняя попытка!");
                        default -> System.out.println(" и исчерпали их. Было загадано число " + target + ".");
                    }
                } else {
                    System.out.println("!");
                }
                if (canTry && ++tryCount > 3) {
                    canTry = false;
                }
            } while (canTry);
            repeat = 1 == getIntFromScanner(scanner, "\nПовторить игру еще раз? 1 – да / 0 – нет. ");
            System.out.println();
        } while (repeat);
    }

    public static int getIntFromScanner(Scanner scanner, String message) {
        do {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.nextLine();
            }
        } while (true);
    }

    /**
     * * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot",
     * "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
     * "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает
     * его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
     * компьютер показывает буквы которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
     */
    public static void guessWord() {
        boolean repeat;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        do {
            List<String> wordsList = new ArrayList<>(Arrays.asList(words));
            System.out.println("Угадайте загаданное слово из массива:\n" + wordsList);
            String target = words[random.nextInt(words.length)];
            StringBuilder hiddenTarget = new StringBuilder("#".repeat(15));
            int guessedChars = 0;
            int tryCount = 0;
            boolean canTry = true;
            do {
                System.out.print("Загаданное: " + hiddenTarget + ". Попробуйте " +
                        (tryCount > 1 ? "ещё раз" : "угадать") + ": ");
                String tryString = scanner.nextLine();
                tryCount++;
                if (Objects.equals(target, tryString)) {
                    System.out.println("Поздравляю!!! Вы угадали! Использованное количество попыток: " + tryCount);
                    canTry = false;
                } else {
                    for (int i = 0; i < target.length() && i < tryString.length(); i++) {
                        if (target.charAt(i) == tryString.charAt(i) && tryString.charAt(i) != hiddenTarget.charAt(i)) {
                            hiddenTarget.replace(i, i + 1, String.valueOf(target.charAt(i)));
                            guessedChars++;
                        }
                    }
                    System.out.println("Пока неудачно" + (guessedChars > 0
                            ? ", но есть совпадение по " + guessedChars + " символам!"
                            : ", но шансы есть! Успехов!"));
//                    excludeImpossibleWords(tryString, hiddenTarget, wordsList);
                }
            } while (canTry);
            repeat = 1 == getIntFromScanner(scanner, "\nПовторить игру еще раз? 1 – да / 0 – нет. ");
            System.out.println(scanner.nextLine());
        } while (repeat);
    }

    /**
     * Упрощение для {@link #guessWord()} - исходный список слов прореживается по попыткам, убираются
     * слова, которые точно не могут быть загаданным:
     * - если буква слова отгадана, но её нет в этом месте слова из списка или слово из списка короче,
     * т.е. недостаточно длинное, чтобы отгаданная буква была в слове;
     * - если буква слова не отгадана, но она есть в этом месте слова, введённом пользователем.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# - отображение загаданного слова
     * {"apple"} остаётся среди возможных, остальные убираются, т.к. не начинаются на 'a', а "avocado"
     * убирается, т.к. второй буквой у него не 'p'.
     * leak - загаданное
     * apricot - ответ игрока
     * ############### - отображение загаданного слова
     * "apple", "apricot", "avocado", "carrot", "garlic" и "kiwi" исключаются, т.к. первая 'a',
     * третья 'r' и четвёртая 'i' есть в ответе и нет в загаданном.
     */
    private static void excludeImpossibleWords(String tryString, StringBuilder hiddenTarget, List<String> wordsList) {
        for (int i = 0; i < tryString.length(); i++) {
            for (Iterator<String> iterator = wordsList.iterator(); iterator.hasNext(); ) {
                String word = iterator.next();
                if ((i >= word.length() && hiddenTarget.charAt(i) != '#')
                        || (i < word.length() && (word.equals(tryString)
                        || (hiddenTarget.charAt(i) == '#' && word.charAt(i) == tryString.charAt(i))
                        || (hiddenTarget.charAt(i) != '#' && word.charAt(i) != tryString.charAt(i))))) {
                    iterator.remove();
                }
            }
        }
        System.out.println("Оставшиеся варианты:\n" + wordsList);
    }
}
