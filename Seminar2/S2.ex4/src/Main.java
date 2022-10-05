// 4. Реализовать метод, который добавляет 1 000 000 случайных элементов в ArrayList и LinkedList.
// Реализовать второй метод, который выбирает из списка элемент наугад 100 000 раз. Замерьте время и скажите кто быстрее.


import java.util.*;


public class Main {
    public static List<Integer> addValue(List<Integer> list) {
        int N = 1000000;
        Random rd = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(rd.nextInt(10));
        }
        System.out.printf("Метод добавляет 1 000 000 элементов за %d mls\n", System.currentTimeMillis() - start);
        return new ArrayList<>(list);
    }

    public static List<Integer> getValue(List<Integer> list) {
        int N = 1000000;
        int K = 100000;
        Random rd = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < K; i++) {
            list.get((int) (Math.random() * (N - 1)));
        }
        System.out.printf("Метод выбирает 100 000 элементов за %d mls\n", System.currentTimeMillis() - start);

        if (list instanceof ArrayList)
            return new ArrayList<>(list);
        else
            return new LinkedList<>(list);
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("\nРаботаем с ArrayList:");
        addValue(arrayList);
        getValue(arrayList);

        System.out.println("Работаем с LinkedList:");
        addValue(linkedList);
        getValue(linkedList);
    }
}