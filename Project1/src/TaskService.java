import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class TaskService {
    public static Task createTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название задачи - ");
        String title = sc.nextLine();
        System.out.print("\nВведите дату выполнения задачи - ");
        String endDate = sc.nextLine();
        System.out.print("\nВведите краткое описание задачи - ");
        String description = sc.nextLine();
        Task task = new Task(title, description, endDate);
        return task;
    }
}
