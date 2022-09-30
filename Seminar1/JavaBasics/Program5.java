package JavaBasics;

import java.util.Scanner;

// 5) Дано два числа a и b. Найдите гипотенузу треугольника с заданными катетами.
public class Program5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Double a = sc.nextDouble();
        Double b = sc.nextDouble();
        System.out.println(Math.sqrt(Math.pow(a, 2) + Math.pow(b,2)));
        sc.close();
    }
}
