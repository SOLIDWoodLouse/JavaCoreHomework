package lesson05.homework;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        maxRunDistance = 200 + (int) (Math.random() * 100);
        maxBounceDistance = 2 + Math.random();
    }

    @Override
    public void swimming(int swimmingDistance) {
        System.out.println("Кот не умеет плавать");
    }
}


