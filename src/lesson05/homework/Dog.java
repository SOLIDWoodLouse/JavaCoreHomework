package lesson05.homework;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        maxRunDistance = 500 + (int) (Math.random() * 100);
        maxBounceDistance = 0.5 + Math.random();
        maxSwimmingDistance = 10 + (int) (Math.random() * 5);

    }

}
