package JavaBasics;

import java.util.Scanner;

// 8) Дано двузначное число. Найдите число десятков в нем.
public class Program8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n/10);
        sc.close();
    }
}
