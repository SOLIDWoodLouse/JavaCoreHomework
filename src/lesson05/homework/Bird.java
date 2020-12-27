package lesson05.homework;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
        maxRunDistance = 5 + (int) (Math.random() * 100);
        maxBounceDistance = 0.2 + Math.random();
    }

    @Override
    public void swimming(int swimmingDistance) {
        System.out.println("Птичка не умеет плавать");
    }

}

