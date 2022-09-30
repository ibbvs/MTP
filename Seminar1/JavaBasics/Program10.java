package JavaBasics;

import java.util.Scanner;


// 10) Реализуйте метод, в который передается две целочисленные переменные и возвращает их среднее арифметическое
public class Program10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println((a+b)/2);
        sc.close();
    }
}
