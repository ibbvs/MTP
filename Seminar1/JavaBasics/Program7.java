package JavaBasics;

import java.util.Scanner;

// 7) Дано неотрицательное целое число. Найдите число десятков в его десятичной записи (то есть вторую справа цифру его десятичной записи).
public class Program7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println((n%100) / 10);
        sc.close();
    }
}
