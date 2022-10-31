import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Reader> readers = new ArrayList<>();
        Reader Person1 = new Reader("Иванов П.О.", 1, "ПИ", "15.01.2000", "89657330125");
        System.out.println(Person1.toString());
        Person1.takeBook(3);
        Person1.takeBook("Стихи", "Ужасы", "Детектив");
        Person1.takeBook(new Book("Илиада", "Гомер"),new Book("10 негритят", "Агата Кристи"));

        Person1.returnBook(2);

        readers.add(Person1);
        readers.add(new Reader("Сидоров С.Я.", 2, "ПМИ", "7.01.2004", "89995553185"));
        readers.add(new Reader("Яковлев К.С.", 3, "БИ", "25.02.1999", "89251735938"));
        System.out.println("\nВсе зарегистрированные в сети ридеры:");
        for (Reader reader: readers) {
            System.out.println(reader);
        }


    }
}