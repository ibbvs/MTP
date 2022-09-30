package JavaBasics;

import java.util.Scanner;

// 12) Реализуйте метод, в который передается 4 числа с плавающей точкой. Первые два числа – координаты x, y
public class Program12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Double x1 = sc.nextDouble();
        Double y1 = sc.nextDouble();
        Double x2 = sc.nextDouble();
        Double y2 = sc.nextDouble();
        System.out.println(Math.sqrt(Math.pow(x2 - x1 ,2) + Math.pow(y2 - y1, 2)));
        sc.close();
    }
}
