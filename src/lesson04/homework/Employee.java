package lesson04.homework;

//1. Создаем класс сотрудник
public class Employee {

    private String fullName, position, phoneNumber;
    private int salary, age, id;

    //2. Создаем конструктор
    public Employee(String fullName, String position, String phoneNumber, int salary, int age, int id) {
        this.fullName = fullName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
        this.id = id;
    }
    //3. Создаем геттеры, которые возвращают значения каждого поля
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
