package ru.khusyainov.gb.java1.hw4;

import java.util.*;

public class HomeWork4 {
    public static char[][] playingField;
    public static final int SIZE = 5;
    public static final int SYMBOLS_TO_WIN = 4;
    public static final char SYMBOL_EMPTY = '•';
    public static final char SYMBOL_HUMAN = 'X';
    public static final char SYMBOL_AI = 'O';
    public static final int SEARCH_ROWS = 1;
    public static final int SEARCH_COLUMNS = 2;
    public static final int SEARCH_LEFT_TO_RIGHT_DIAGONALS = 3;
    public static final int SEARCH_RIGHT_TO_LEFT_DIAGONALS = 4;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        do {
            initializeField();
            printField();
            boolean humanWin, aiWin;
            do {
                humanMove();
                humanWin = checkWin(SYMBOL_HUMAN);
                if (!humanWin && hasEmptyCells()) {
                    aiMove();
                }
                aiWin = checkWin(SYMBOL_AI);
                printField();
            } while (!humanWin && !aiWin && hasEmptyCells());
            if (humanWin) {
                System.out.println("\n\t\tВы выиграли! Примите поздравления!");
            } else if (aiWin) {
                System.out.println("\n\t\tИИ выиграл! Поздравим победителя!?)");
            } else {
                System.out.println("\n\t\tНичья!");
            }
            System.out.print("\nВведите 1, если хотите сыграть ещё или любую другую цифру для выхода: ");
        } while (scanner.nextInt() == 1);
    }

    public static void initializeField() {
        playingField = new char[SIZE][SIZE];
        for (char[] cellsRow : playingField) {
            Arrays.fill(cellsRow, SYMBOL_EMPTY);
        }
    }

    public static void printField() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < playingField.length; i++) {
            System.out.print(i + 1 + " ");
            for (char columnCell : playingField[i]) {
                System.out.print(columnCell + " ");
            }
            System.out.println();
        }
    }

    public static void humanMove() {
        int x, y;
        do {
            System.out.print("Введите координаты в формате X Y (через пробел) для крестика: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isNotAcceptableOrCellNotEmpty(x, y));
        playingField[x][y] = SYMBOL_HUMAN;
    }

    public static void aiMove() {
        int x = -1, y = -1;
        boolean humanPreWin = false;
        for (int preWinAmount = SYMBOLS_TO_WIN - 1; preWinAmount >= SYMBOLS_TO_WIN - 2; preWinAmount--) {
            for (int searchDirection = SEARCH_ROWS, start, end; searchDirection <= SEARCH_RIGHT_TO_LEFT_DIAGONALS;
                 searchDirection++) {
                if (searchDirection == SEARCH_ROWS || searchDirection == SEARCH_COLUMNS) {
                    start = 0;
                    end = SIZE - 1;
                } else {
                    start = -SIZE + SYMBOLS_TO_WIN;
                    end = SIZE - SYMBOLS_TO_WIN;
                }
                for (int i = start; i <= end; i++) {
                    Map.Entry<Integer, Integer> freeCell =
                            getFreeCellNumberInDirection(i, searchDirection, preWinAmount);
                    if (freeCell.getKey() != -1) {
                        x = freeCell.getKey();
                        y = freeCell.getValue();
                        humanPreWin = true;
                        break;
                    }
                }
                if (humanPreWin) {
                    break;
                }
            }
            if (humanPreWin) {
                break;
            }
        }
        if (!humanPreWin) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (isNotAcceptableOrCellNotEmpty(x, y));
        }
        playingField[x][y] = SYMBOL_AI;
        System.out.println("ИИ поставил нолик по координатам X Y (через пробел): " + ++x + " " + ++y +
                " (" + (humanPreWin ? "намеренно))" : "случайно)"));
    }

    public static boolean isAcceptable(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    public static boolean isNotAcceptableOrCellNotEmpty(int x, int y) {
        return !isAcceptable(x, y) || playingField[x][y] != SYMBOL_EMPTY;
    }

    public static boolean checkWin(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            if (isSymbolsCountInDirectionEqualsToTarget(i, SEARCH_ROWS, symbol, SYMBOLS_TO_WIN) ||
                    isSymbolsCountInDirectionEqualsToTarget(i, SEARCH_COLUMNS, symbol, SYMBOLS_TO_WIN)) {
                return true;
            }
        }
        for (int i = -SIZE + SYMBOLS_TO_WIN; i <= SIZE - SYMBOLS_TO_WIN; i++) {
            if (isSymbolsCountInDirectionEqualsToTarget(i, SEARCH_LEFT_TO_RIGHT_DIAGONALS,
                    symbol, SYMBOLS_TO_WIN) ||
                    isSymbolsCountInDirectionEqualsToTarget(i, SEARCH_RIGHT_TO_LEFT_DIAGONALS,
                            symbol, SYMBOLS_TO_WIN)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSymbolsCountInDirectionEqualsToTarget(int rowNumber, int searchDirection,
                                                                  char symbol, int targetSymbolsCount) {
        int symbolsCount = 0;
        for (int j = 0; j < SIZE; j++) {
            switch (searchDirection) {
                case SEARCH_ROWS -> symbolsCount =
                        increaseOrResetSymbolsCount(symbol, symbolsCount, rowNumber, j);
                case SEARCH_COLUMNS -> symbolsCount =
                        increaseOrResetSymbolsCount(symbol, symbolsCount, j, rowNumber);
                case SEARCH_LEFT_TO_RIGHT_DIAGONALS -> symbolsCount =
                        increaseOrResetSymbolsCount(symbol, symbolsCount, j, rowNumber + j);
                case SEARCH_RIGHT_TO_LEFT_DIAGONALS -> symbolsCount =
                        increaseOrResetSymbolsCount(symbol, symbolsCount, j, SIZE - rowNumber - j - 1);
            }
            if (symbolsCount == targetSymbolsCount) {
                return true;
            }
        }
        return false;
    }

    public static Map.Entry<Integer, Integer> getFreeCellNumberInDirection(int rowNumber, int searchDirection,
                                                                           int preWinAmount) {
        int symbolsCount = 0;
        AbstractMap.SimpleEntry<Integer, Integer> lastFreeCell = new AbstractMap.SimpleEntry<>(-1, -1);
        boolean humanPreWin = false;
        for (int j = 0; j < SIZE; j++) {
            switch (searchDirection) {
                case SEARCH_ROWS -> {
                    symbolsCount = increaseOrResetSymbolsCount(SYMBOL_HUMAN, symbolsCount, rowNumber, j);
                    humanPreWin = preWinAmount == symbolsCount;
                    if (isCurrentCellBusyAndNeighbourEmpty(rowNumber, j, rowNumber, j - 1)) {
                        lastFreeCell = new AbstractMap.SimpleEntry<>(rowNumber, j - 1);
                    }
                    if (humanPreWin && isCurrentCellBusyAndNeighbourEmpty(rowNumber, j, rowNumber, j + 1)) {
                        lastFreeCell = new AbstractMap.SimpleEntry<>(rowNumber, j + 1);
                    }
                }
                case SEARCH_COLUMNS -> {
                    symbolsCount = increaseOrResetSymbolsCount(SYMBOL_HUMAN, symbolsCount, j, rowNumber);
                    humanPreWin = preWinAmount == symbolsCount;
                    if (isCurrentCellBusyAndNeighbourEmpty(j, rowNumber, j - 1, rowNumber)) {
                        lastFreeCell = new AbstractMap.SimpleEntry<>(j - 1, rowNumber);
                    }
                    if (humanPreWin && isCurrentCellBusyAndNeighbourEmpty(j, rowNumber, j + 1, rowNumber)) {
                        lastFreeCell = new AbstractMap.SimpleEntry<>(j + 1, rowNumber);
                    }
                }
                case SEARCH_LEFT_TO_RIGHT_DIAGONALS -> {
                    symbolsCount = increaseOrResetSymbolsCount(SYMBOL_HUMAN, symbolsCount, j, rowNumber + j);
                    humanPreWin = preWinAmount == symbolsCount;
                    if (isCurrentCellBusyAndNeighbourEmpty(
                            j, rowNumber + j, j - 1, rowNumber + j - 1)) {
                        lastFreeCell = new AbstractMap.SimpleEntry<>(j - 1, rowNumber + j - 1);
                    }
                    if (humanPreWin && isCurrentCellBusyAndNeighbourEmpty(
                            j, rowNumber + j, j + 1, rowNumber + j + 1)) {
                        lastFreeCell = new AbstractMap.SimpleEntry<>(j + 1, rowNumber + j + 1);
                    }
                }
                case SEARCH_RIGHT_TO_LEFT_DIAGONALS -> {
                    symbolsCount =
                            increaseOrResetSymbolsCount(SYMBOL_HUMAN, symbolsCount, j, SIZE - rowNumber - j - 1);
                    humanPreWin = preWinAmount == symbolsCount;
                    if (isCurrentCellBusyAndNeighbourEmpty(
                            j, SIZE - rowNumber - j - 1, j - 1, SIZE - rowNumber - j)) {
                        lastFreeCell = new AbstractMap.SimpleEntry<>(j - 1, SIZE - rowNumber - j);
                    }
                    if (humanPreWin && isCurrentCellBusyAndNeighbourEmpty(
                            j, SIZE - rowNumber - j - 1, j + 1, SIZE - rowNumber - j - 2)) {
                        lastFreeCell = new AbstractMap.SimpleEntry<>(j + 1, SIZE - rowNumber - j - 2);
                    }
                }
            }
            if (humanPreWin) {
                return lastFreeCell;
            }
        }
        if (lastFreeCell.getKey() != -1) {
            lastFreeCell = new AbstractMap.SimpleEntry<>(-1, -1);
        }
        return lastFreeCell;
    }

    private static boolean isCurrentCellBusyAndNeighbourEmpty(int currentX, int currentY, int nextX, int nextY) {
        return isAcceptable(currentX, currentY) && playingField[currentX][currentY] != SYMBOL_EMPTY &&
                isAcceptable(nextX, nextY) && playingField[nextX][nextY] == SYMBOL_EMPTY;
    }

    public static int increaseOrResetSymbolsCount(char symbol, int symbolsCount, int i, int j) {
        if (isAcceptable(i, j)) {
            if (playingField[i][j] == symbol) {
                return ++symbolsCount;
            } else {
                return 0;
            }
        } else {
            return symbolsCount;
        }
    }

    public static boolean hasEmptyCells() {
        for (char[] cellsRow : playingField) {
            for (char cell : cellsRow) {
                if (cell == SYMBOL_EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }
}
