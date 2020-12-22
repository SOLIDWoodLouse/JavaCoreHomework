package lesson04.homework;

public class Main {

    //7.1. Начало счетчика для айдишки сотрудника
    public static int id = 0;

    public static void main(String[] args) {

        //4.1. Создаем сотрудников и присваиваем значения переменным с помощью конструктора
        Employee employee01 = new Employee("Пупкин Василий Иванович",
                "Android developer",
                "8-999-822-86-91",
                30000,
                41,
                setIdForEmployee());
        Employee employee02 = new Employee("Иванов Иван Иванович",
                "Бариста",
                "8-925-822-86-91",
                60000,
                37,
                setIdForEmployee());
        Employee employee03 = new Employee("Сергеев Сергей Сергеев",
                "Мойщик котов",
                "8-925-542-86-91",
                100000,
                45,
                setIdForEmployee());
        Employee employee04 = new Employee("Петров Петр Петрович",
                "Капустный мастер",
                "8-925-822-00-91",
                340000,
                60,
                setIdForEmployee());
        Employee employee05 = new Employee("Карасик Карасиков Карасьев",
                "Повар",
                "8-925-822-86-12",
                320000,
                27,
                setIdForEmployee());

        //4.2. Выводим ФИО И должность с помощью методов.
        System.out.println(employee01.getFullName() + " - " + employee01.getPosition() + "\n");

        //5.1. Создаем массив  из 5 сотрудников
        Employee[] employees = new Employee[]{employee01, employee02, employee03, employee04, employee05};

        //5.3. Выводим сотрудников старше 40 лет
        getOlderEmployees(employees, 40);
        //6.2 Повышаем смотрудникам старше 35 лет на 10к
        socialHelp(employees);

        getOlderEmployees(employees, 0);

    }

    //5.2 Создаем метод, который выводит данный сотрудлников которым больше 40 лет
    public static void getOlderEmployees(Employee[] employees, int age) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() >age) {
                System.out.println(employees[i].getFullName() + "\nдолжность: " +
                        employees[i].getPosition() + "\nтелефон: " +
                        employees[i].getPhoneNumber() + "\nежемесячный доход: " +
                        employees[i].getSalary() + "\nвозраст: " +
                        employees[i].getAge() + "\nid:" +
                        employees[i].getId() + "\n________");
            }
        }
    }

    // 6.1 Создаем метод для повышения зп людям, старше 35 лет на 10к
    public static void socialHelp(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 35) {
                employees[i].setSalary(employees[i].getSalary() + 10000);
            }
        }
    }

    //7.2. Метод с помощью которого можно присвоить уникальный номер для сотрудников. Даже если где то в программе вне
    // конструктора Employee будет использован этот метод, айди будет уникально.
    public static int setIdForEmployee() {
        id++;
        return id;
    }

}
