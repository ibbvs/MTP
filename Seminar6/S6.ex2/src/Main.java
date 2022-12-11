
import java.util.Random;
import java.util.Scanner;

public class Main {

    static boolean SimpleSearcher(int [] array, int searchValue) {
        for (int i = 0; i < array.length; i++) {

            if (array[i] == searchValue)
                return true;

        }
        return false;
    }



    static boolean BinarySearch(int [] array, int firstElement, int lastElement, int elementToSearch) {

        if (lastElement >= firstElement) {

            int mid = firstElement + (lastElement - firstElement) / 2;

            if (array[mid] == elementToSearch)
                return true;

            if (array[mid] > elementToSearch)
                return BinarySearch(array, firstElement, mid - 1, elementToSearch);

            return BinarySearch(array, mid + 1, lastElement, elementToSearch);
        }

        return false;
    }


    public static void main(String[] args) {
        Random random = new Random();
        int[] rArray = random.ints(100000000, 0,1000).toArray(); // создание массива заполненного рандомно

        int[] sArray = new int[100000000]; // создание отсортированного массива
        for (int i = 0; i < sArray.length; i++) {
            sArray[i] = i;
        }


        System.out.println("Введите натуральное число n :");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        while (number < 0 || number > sArray.length) {
            System.out.println("Введено некоректное число, введите число от 0 до 100");
            number = scanner.nextInt();
        }
        System.out.printf("Поиск числа %d в рандомно заполненом массиве\n", number);
        long startTime = System.nanoTime();
        SimpleSearcher(rArray, number);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.printf("Время работы метода простого поиска: %d нс.\n" ,duration);

        startTime = System.nanoTime();
        BinarySearch(rArray, 0, rArray.length, number);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.printf("Время работы метода бинарного поиска: %d нс.\n" ,duration);



        System.out.printf("\n\nПоиск числа %d в отсортированном массиве\n", number);
        startTime = System.nanoTime();
        SimpleSearcher(sArray, number);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.printf("Время работы метода простого поиска: %d нс.\n" ,duration);


        startTime = System.nanoTime();
        BinarySearch(sArray, 0, sArray.length, number);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.printf("Время работы метода бинарного поиска: %d нс.\n" ,duration);

    }
}