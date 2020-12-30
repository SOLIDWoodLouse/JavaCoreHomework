package lesson05.homework;

public class Main {
    public static void main(String[] args) {

        Dog tusic = new Dog("Тузик");
        Horse black = new Horse("Черная");
        Bird chiric = new Bird("Чирик");
        Cat pushok = new Cat("Пушок");

        tusic.run(500);
        tusic.bounce(0.6);
        tusic.swimming(10);

        black.run(500);
        black.bounce(4.6);
        black.swimming(110);

        chiric.run(12);
        chiric.bounce(0.6);
        chiric.swimming(10);

        pushok.run(210);
        pushok.bounce(2.2);
        pushok.swimming(10);

    }
}
