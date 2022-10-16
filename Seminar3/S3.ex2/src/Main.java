
import java.util.*;

/*
Создать 3 класса(базовый и 2 дочерних) которые описывают некоторых работников с почасовой оплатой (один из дочерних) и фиксированой оплатой (второй дочерний).

    Описать в базовом классе абстрактный метод для расчета среднемесячной зарплаты.
    Для «почасовщиков» формула для расчета такая: «среднемесячная зарплата = 20.8*8*ставка в час»,
    для работников с фиксированой оплатой «среднемесячная зарплата = фиксированой месячной оплате».
        a)Упорядочить всю последовательность рабочих по убыванию среднемесячной зарплаты.
        При совпадении зарплаты – упорядочить данные в алфавитном порядке по имени. Вывести идентификатор работника,
        имя и среднемесячную зарплату для всех елементов списка.
        b)Вывести первые 5 имен работников из полученого выше списка (задача А).
        c)Вывести последние 3 идентификаторы работников из полученого више списка (задача А).
        d)Организовать запись и чтение колекции в/из файл(а)
        e)Организовать обработку некоректного формата входного файла */

abstract class Employee implements Comparable<Employee> {
    private static int counter = 0;
    private int id;
    private String name;

    protected Employee(String name) {
        this.name = name;
        id = ++counter;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    abstract public double getPayroll();

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.getName());
    }



}


class fixedPaymentEmployee extends Employee {
    private double monthlyRate;

    public fixedPaymentEmployee(String name, double monthlyRate) {
        super(name);
        this.monthlyRate = monthlyRate;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    @Override
    public double getPayroll() {
        return monthlyRate;
    }
}


class hourlyPaymentEmployee extends Employee {
    private double hourlyRate;

    public hourlyPaymentEmployee(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPayroll() {
        return 20.8 * 8 * this.hourlyRate;
    }
}





public class Main {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new fixedPaymentEmployee("Alice Cooper", 1300));
        employees.add(new fixedPaymentEmployee("Darth Vader", 3500));
        employees.add(new fixedPaymentEmployee("Johnny Silverhand", 1000));
        employees.add(new fixedPaymentEmployee("Homer Simpson", 500));
        employees.add(new fixedPaymentEmployee("John Travolta", 2300));
        employees.add(new hourlyPaymentEmployee("Rulon Oboev", 7));
        employees.add(new hourlyPaymentEmployee("Ingeborga Dapkunaite", 20));
        employees.add(new hourlyPaymentEmployee("Lionel Messi", 40));
        employees.add(new hourlyPaymentEmployee("Yurik Thursday", 15));
        employees.add(new hourlyPaymentEmployee("Maif Koja", 16));
        employees.add(new hourlyPaymentEmployee("Jamil Asanov", 21));
        //System.out.println(employees.get(1).getPayroll());
        //System.out.println(employees.get(10).getName());
        System.out.println("Сортировка по имени: ");
        Collections.sort(employees);
        for (Employee employee: employees) {
            System.out.printf("id=%d - %s: %.2f$\n", employee.getId(), employee.getName(), employee.getPayroll());
        }
        System.out.println();

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o2.getPayroll() - o1.getPayroll());
            }
        });
        System.out.println("Сортировка по убыванию зп: ");
        for (Employee employee: employees) {
            System.out.printf("id=%d - %s: %.2f$\n", employee.getId(), employee.getName(), employee.getPayroll());
        }

        System.out.println();

        System.out.println("\nПервые 5 имён работников из текущего списка");
        for (int i = 0; i < 5; i++) {
            System.out.println("Работник: " + employees.get(i).getName());
        }
    }
}