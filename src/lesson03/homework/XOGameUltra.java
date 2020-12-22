package lesson03.homework;

import java.util.Random;
import java.util.Scanner;

public class XOGameUltra {

    public static final char HUMAN_DOT = 'X';
    public static final char PC_DOT = 'O';
    public static final char EMPTY_DOT = '_';

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static char[][] map;
    public static int mapSize;

    public static int winingStreakHuman;
    public static int winingStreakPc;
    public static int winingStreak;

    public static void main(String[] args) {

        winingStreak = 4;

        initMap();

        while (winingStreakPc < winingStreak && winingStreakHuman < winingStreak) {

            printMap();
            humanTurn();
            printMap();

            if (checkWin(HUMAN_DOT)) {
                winingStreakHuman++;
                System.out.println("Human win!\nHuman - " + winingStreakHuman + "\nPC - " + winingStreakPc);
                initMap();
                continue;
            }
            if (isMapFull()) {
                winingStreakPc++;
                winingStreakHuman++;
                System.out.println("Ничья!\nHuman - " + winingStreakHuman + "\nPC - " + winingStreakPc);
                initMap();
                continue;
            }
            aiTurn();

            if (checkWin(PC_DOT)) {
                winingStreakPc++;
                System.out.println("AI win!\nHuman - " + winingStreakHuman + "\nPC - " + winingStreakPc);
                initMap();
                continue;
            }
            if (isMapFull()) {
                winingStreakPc++;
                winingStreakHuman++;
                System.out.println("Ничья!\nHuman - " + winingStreakHuman + "\nPC - " + winingStreakPc);
                initMap();
            }
        }
        whoWin();
    }

    public static void initMap() {
        mapSize = 5;
        map = new char[mapSize][mapSize];

        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                map[y][x] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < mapSize && y >= 0 && y < mapSize;
    }

    public static boolean isEmptyCell(int y, int x) {
        return map[y][x] == EMPTY_DOT;
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Введите свои координаты: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;

        } while (!isValidCell(y, x) || !isEmptyCell(y, x));
        map[y][x] = HUMAN_DOT;
    }

    public static boolean checkWin(char inboxChar) {
        int numOfHitsHor, numOfHitsVer;
        int numOfHitsDiagonalOne = 0;
        int numOfHitsDiagonalTwo = 0;
        for (int i = 0; i < mapSize; i++) {
            if (map[i][i] == inboxChar) {
                numOfHitsDiagonalOne++;
            }
            if (map[i][mapSize - i - 1] == inboxChar) {
                numOfHitsDiagonalTwo++;
            }
            if (numOfHitsDiagonalOne == mapSize || numOfHitsDiagonalTwo == mapSize) {
                return true;
            }
            numOfHitsHor = 0;
            numOfHitsVer = 0;
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == inboxChar) {
                    numOfHitsHor++;
                }
                if (map[j][i] == inboxChar) {
                    numOfHitsVer++;
                }
                if (numOfHitsHor == mapSize || numOfHitsVer == mapSize) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (map[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int numOfHitsHor, numOfHitsVer;
        int numOfHitsDiagonalOne = 0;
        int numOfHitsDiagonalTwo = 0;
        //Тут начинается проверка на выйгрышный ход противника
        for (int i = 0; i < mapSize; i++) {
            if (map[i][i] == HUMAN_DOT) {
                numOfHitsDiagonalOne++;
                if (numOfHitsDiagonalOne == mapSize - 1) {
                    for (int j = 0; j < mapSize; j++) {
                        if (isEmptyCell(j, j)) {
                            map[j][j] = PC_DOT;
                            return;
                        }
                    }
                }
            }
            if (map[i][mapSize - i - 1] == HUMAN_DOT) {
                numOfHitsDiagonalTwo++;
                if (numOfHitsDiagonalTwo == mapSize - 1) {
                    for (int j = 0; j < mapSize; j++) {
                        if (isEmptyCell(j, mapSize - j - 1)) {
                            map[j][mapSize - j - 1] = PC_DOT;
                            return;
                        }
                    }
                }
            }
            numOfHitsHor = 0;
            numOfHitsVer = 0;
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == HUMAN_DOT) {
                    numOfHitsHor++;
                    if (numOfHitsHor == mapSize - 1) {
                        for (int k = 0; k < mapSize; k++) {
                            if (isEmptyCell(i, k)) {
                                map[i][k] = PC_DOT;
                                return;
                            }
                        }
                    }
                }
                if (map[j][i] == HUMAN_DOT) {
                    numOfHitsVer++;
                    if (numOfHitsVer == mapSize - 1) {
                        for (int k = 0; k < mapSize; k++) {
                            if (isEmptyCell(k, i)) {
                                map[k][i] = PC_DOT;
                                return;
                            }
                        }
                    }
                }

            }
        }
        //если ничего не находит, ИИ ставит рандомно
        int x;
        int y;
        do {
            x = RANDOM.nextInt(mapSize);
            y = RANDOM.nextInt(mapSize);
        } while (!isEmptyCell(y, x));
        map[y][x] = PC_DOT;
    }

    public static void whoWin() {
        if (winingStreakHuman == winingStreak && winingStreakPc == winingStreak) {
            System.out.println("Ничья! Игра окончена.");
        } else if (winingStreakHuman == winingStreak) {
            System.out.println("Человек победил машину! Игра окончена.");
        } else if (winingStreakPc == winingStreak) {
            System.out.println("Машина победила, опять. Игра окончена.");
        }
    }

}
