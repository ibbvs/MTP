import java.util.Scanner;

public class Main {
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Введите размер буфера (число от 2 до 10)");
        int n = IsCorrect();
        while (n < 2 || n > 10) {
            System.out.println("Некорректное число, введите ещё раз");
            n = IsCorrect();
        }
        Buffer buffer = new Buffer(n);
        Manufacturer manufacturer = new Manufacturer(buffer);
        Consumer consumer = new Consumer(buffer);
        manufacturer.start();
        consumer.start();
        Thread.sleep(10000);
        manufacturer.interrupt();
        consumer.interrupt();
        manufacturer.join();
        consumer.join();
        System.out.println("Конец");

    }

    public static boolean IsNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int IsCorrect() {
        String str = in.nextLine();
        while (!IsNumeric(str)) {
            System.out.println("Not a number entered. Try again:");
            str = in.nextLine();
        }
        return Integer.parseInt(str);
    }
}