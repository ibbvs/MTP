package JavaBasics;

import java.util.Scanner;

// 9) Реализуйте метод, который получает целое число на вход и возвращает разницу между данным числом и 21.
public class Program9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n-21);
        sc.close();
    }
}
