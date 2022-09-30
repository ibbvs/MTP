package JavaBasics;

import java.util.Scanner;

// 11) Реализуйте метод, в который передается две целочисленные переменные и возвращает их среднее геометрическое
public class Program11 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(Math.sqrt(a*b));
        sc.close();
    }
}
