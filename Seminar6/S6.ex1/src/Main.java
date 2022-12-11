import java.util.Scanner;

public class Main {
    static String recursiveOutputNumbers(int i) {
        if (i == 1) {
            return "1";
        }
        return recursiveOutputNumbers(i - 1) + "; " + i;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(recursiveOutputNumbers(n));
    }


}
