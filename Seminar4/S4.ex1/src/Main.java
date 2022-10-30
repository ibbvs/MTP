import java.util.Scanner;

enum Season {
    WINTER("Зима", -30, "Холодное время года"),
    SPRING("Весна", 20, "Холодное время года"),
    SUMMER("Лето", 33, "Теплое время года"),
    AUTUMN("Осень", 7, "Холодное время года");

    private String title;
    private float tmp;
    private String description;

    Season(String title, float tmp, String description) {
        this.title = title;
        this.tmp = tmp;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public float getTmp() {
        return tmp;
    }

    public String getDescription() {
        return description;
    }

    public void setTmp(float newTmp) {
        this.tmp = newTmp;
    }

    @Override
    public String toString() {
        return "Сезон: " + title + "\nСредняя температура = " + tmp;
    }
}


public class Main {

    static void getLove(Season title) {
        switch (title) {
            case WINTER:
                System.out.println("Я люблю Зиму");
                break;
            case SPRING:
                System.out.println("Я люблю Весну");
                break;
            case SUMMER:
                System.out.println("Я люблю Лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю Осень");
                break;
        }

    }

    public static void main(String[] args) {
        Season seasons[] = new Season[]{Season.WINTER, Season.SPRING, Season.SUMMER, Season.AUTUMN};
        System.out.print("Моё любимое время года - ");
        Season mfs = Season.AUTUMN;
        System.out.println(mfs.toString());
        mfs.setTmp(15);
        System.out.print("Я изменил температуру своего любимого времени года и теперь - ");
        System.out.println(mfs.toString());
        System.out.printf("Вызываю функцию getDescription для описания своего времени года: %s\n", mfs.getDescription());
        getLove(Season.SUMMER);
        for (int i = 0; i < 4; i++) {
            System.out.printf("\nНазвание сезона - %s\nСредняя температура - %s\nОписание - %s\n\n", seasons[i].getTitle(), seasons[i].getTmp(), seasons[i].getDescription());
        }
    }
}
