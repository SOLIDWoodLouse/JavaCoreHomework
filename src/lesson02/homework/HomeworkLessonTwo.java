package lesson02.homework;

import java.util.Arrays;

public class HomeworkLessonTwo {

    public static void main(String[] args) {

        int[] a = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeElement(a);
        System.out.println(Arrays.toString(a));

        int[] b = new int[8];
        fillArr(b);
        System.out.println(Arrays.toString(b));

        int[] c = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        fixElement(c);
        System.out.println(Arrays.toString(c));

        int[] d = new int[]{5, 6, 7, 3, 2, 1};
        System.out.println("Максимальный элемент массива: " + maxElement(d) + "\nМинимальный элемент массива: " + minElement(d));

        int[][] e = new int[8][8];
        setDiagonal(e);
        getArrElements(e);

        int[] f = new int[]{3, 2, 1};
        System.out.println(checkBalance(f));

        int[] g = new int[]{1, 2, 3, 4, 5, 6};
        moveElementWithoutArr(g, -9);
        System.out.println(Arrays.toString(g));

        int[] h = new int[]{1, 2, 3, 4, 5, 6};
        moveElementWithoutArr(h, 8);
        System.out.println(Arrays.toString(h));

    }

    private static void changeElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + i * 3;
        }
    }

    private static void fixElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
    }

    private static int minElement(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int maxElement(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void setDiagonal(int[][] arr) {
        int j = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][j] = 1;
            j--;
        }
    }

    private static void getArrElements(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static boolean checkBalance(int[] arr) {
        int rightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            rightSum = rightSum + arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                leftSum += arr[j];
            }
            if (rightSum == leftSum) {
                return true;
            }
        }
        return false;
    }

    public static void moveElementWithoutArr(int[] arr, int num) {
        int size = arr.length;
        if (num > 0) {
            for (int i = 0; i < num; i++) {
                int helpNum = arr[size - 1];
                for (int j = size - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = helpNum;
            }
        } else {
            for (int i = 0; i > num; i--) {
                int helpNum = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[size - 1] = helpNum;
            }
        }
    }

}
