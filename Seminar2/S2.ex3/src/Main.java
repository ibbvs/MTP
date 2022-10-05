// 3. Реализуйте метод, который на вход получает любую коллекцию и возвращает коллекцию уже без дубликатов.

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;

public class Main {

    public static <T>Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }
    public static void main(String[] args) {
        ArrayList<Integer> test1 = new ArrayList<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            test1.add((int) (Math.random() * 7));
        }
        System.out.println("Исходная int коллекция: ");
        System.out.println(test1);
        System.out.println("Коллекция после удаления дупликатов:");
        System.out.println(removeDuplicates(test1));

        ArrayList<String> test2 = new ArrayList<>(Arrays.asList("a", "b", "c", "a", "q"));
        System.out.println("\n\nИсходная str коллекция: ");
        System.out.println(test2);
        System.out.println("Коллекция после удаления дупликатов:");
        System.out.println(removeDuplicates(test2));
    }
}