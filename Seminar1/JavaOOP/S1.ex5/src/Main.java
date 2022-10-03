// 5. Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.

import java.util.Random;

class Array {
    int[] result;

    public Array(int[] values, int[] scales) {
        int sum = 0;
        // Длина нового массива
        for (int i: scales) {
            sum += i;
        }

        result = new int[sum];
        // Добавляем элементы в массив
        int counter = 0;
        System.out.print("Массив: ");
        for (int i = 0; i < scales.length; i++) {
            for (int j = 0; j < scales[i]; j++) {
                result[counter] = values[i];
                counter += 1;
            }
        }
        System.out.println(java.util.Arrays.toString(result));
    }

    public int getValue() {
        return (int) (Math.random() * result.length - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Random rd = new Random();

        int[] values = {1, 2, 3};
        int[] scales = {2, 3, 7};

        Array array = new Array(values, scales);
        System.out.printf("\nПолученный элемент: %d\n", array.getValue());
    }
}