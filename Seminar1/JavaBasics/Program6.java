package JavaBasics;

import java.util.Scanner;

// 6) Дано натуральное число. Выведите его последнюю цифру.
public class Program6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n%10);
        sc.close();
    }
}
