import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class TaskStore {
    ArrayList taskList = new ArrayList();

    public TaskStore(ArrayList taskList) throws IOException {
        this.taskList = taskList;

    }



    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Задача добавлена в список дел!");
    }

    public void deleteTask() {
        System.out.print("Введите id задачи - ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Task task = (Task) taskList.get(id - 1);
        taskList.remove(task);
        System.out.println("Задача удалена из списка дел!");
    }





    public void showTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Список дел пуст!");
        } else {
            System.out.println("Список дел:");


        }
    }
}
