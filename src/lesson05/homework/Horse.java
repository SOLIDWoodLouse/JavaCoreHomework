package lesson05.homework;

public class Horse extends Animal {

    public Horse(String name) {
        super(name);
        maxRunDistance = 1500 + (int) (Math.random() * 100);
        maxBounceDistance = 3 + Math.random();
        maxSwimmingDistance = 100 + (int) (Math.random() * 5);

    }

}
