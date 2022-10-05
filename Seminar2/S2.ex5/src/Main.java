//5. Реализовать частотный словарь слов русского языка (на вход принимается текст любой размерности)



import java.util.*;

public class Main {

    public static ArrayList<String> getRawStr(String text) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.toLowerCase().replaceAll("(?U)[\\pP\\s]", " ").split(" ")));
        words.removeIf(word -> word.equals(""));
        return words;
    }


    public static void main(String[] args) {

        String text = "Зачем опять меняемся местами,\n" +
                "     зачем опять, всё менее нужна,\n" +
                "     плывет ко мне московскими мостами\n" +
                "     посольских переулков тишина?\n" +
                "\n" +
                "     И сызнова полет автомобильный\n" +
                "     в ночи к полупустым особнякам,\n" +
                "     как сызмала, о город нелюбимый,\n" +
                "     к изогнутым и каменным цветам.\n" +
                "\n" +
                "     И веточки невидимо трясутся,\n" +
                "     да кружится неведомо печаль:\n" +
                "     унылое и легкое распутство,\n" +
                "     отчужденности слабая печать.\n" +
                "\n" +
                "     Затем. Затем торопишься пожить.\n" +
                "     Затем, что это юмор неуместный,\n" +
                "     затем, что наши головы кружит\n" +
                "     двадцатый век, безумное спортсменство.";


        Map<String, Integer> dictionary = new HashMap<String, Integer>(); // пустой словарь

        ArrayList<String> rawWords = getRawStr(text); // получение сырых строк
        //System.out.println(rawWords);
        for (String word : rawWords) {
            dictionary.compute(word, (key, value) -> value == null ? 1 : ++value); // создание связки ключ-значение
        }

        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            System.out.printf("%s - %s\n", entry.getKey(), entry.getValue()); //вывод
        }
    }
}
