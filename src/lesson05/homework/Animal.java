package lesson05.homework;

public class Animal {

    protected String name;
    protected int maxRunDistance, maxSwimmingDistance;
    protected double maxBounceDistance;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int runDistance) {
        System.out.println("Максимальное растояние бега - " + maxRunDistance);
        if (maxRunDistance >= runDistance) {
            System.out.println(name + " пробежал(а) " + runDistance + " метр(ов)");
        } else {
            System.out.println(name + " не преодолел(а) дистанцию");
        }
    }

    public void bounce(double bounceDistance) {
        System.out.println("Максимальная высота прыжка - " + maxBounceDistance);
        if (maxBounceDistance >= bounceDistance) {
            System.out.println(name + " проплыл(а) " + bounceDistance + " метр(ов)");
        } else {
            System.out.println(name + " не преодолел(а) дистанцию");
        }

    }

    public void swimming(int swimmingDistance) {
        System.out.println("Максимальное растояние заплыва - " + maxSwimmingDistance);
        if (maxSwimmingDistance >= swimmingDistance) {
            System.out.println(name + " проплыл(а) " + swimmingDistance + " метр(ов)");
        } else {
            System.out.println(name + " не преодолел(а) дистанцию");
        }
    }

}
