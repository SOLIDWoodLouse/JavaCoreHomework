package lessonOne;

public class HomeworkLessonOne {


    public static void main(String[] args) {

        System.out.println(firstTask(1, 2 ,5 ,3));
        System.out.println(secondTask(5, 5));
        thirdTask(0);
        fourthTask("Петя");
        fifthTask(700);

    }

    public static double firstTask(int a, int b, int c, int d) {

        return a * (b + ((double) c / d));

    }

    public static boolean secondTask(int a, int b) {

        return (a + b) >= 10 && (a + b) <= 20;

    }

    public static void thirdTask(int a) {

        if (a < 0) {
            System.out.println("Число отрицательное!");
        } else {
            System.out.println("Число положительное!");
        }

    }

    public static void fourthTask(String name) {

        System.out.println("Привет, " + name);

    }

    public static void fifthTask(int year) {

        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " год является високосным!");
        } else {
            System.out.println(year + " год не является високосным!");
        }

    }

}