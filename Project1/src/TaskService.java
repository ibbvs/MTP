import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


public class TaskService {

    //инициализация, создание массива под список задач
    static ArrayList<Task> taskList = new ArrayList();

    public TaskService(ArrayList taskList) throws IOException {
        this.taskList = taskList;

    }

    // создание задачи
    public static Task createTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название задачи - ");
        String title = sc.nextLine();
        System.out.print("\nВведите дату выполнения задачи - ");
        String endDate = sc.nextLine();
        System.out.print("\nВведите краткое описание задачи - ");
        String description = sc.nextLine();
        boolean flag = false;
        Task task = new Task(title, description, endDate, flag);
        return task;
    }


    public static Task searchTask() {
        System.out.print("Введите id задачи - ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Task task = taskList.get(id - 1);
        return task;
    }


    //добавление в список
    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Задача добавлена в список дел!");
    }

    // внесение изменений в задачу
    public void changeTask() {
        Scanner sc = new Scanner(System.in);

        Task task = searchTask();
        System.out.println("Хотите отметить задание как выполненное? ['да', 'нет']");
        String answer = sc.nextLine();
        if (answer.equals("да"))
            task.setFlag(true);
        System.out.println("Введите новое имя задачи либо нажмите Enter");
        String title = sc.nextLine();
        if (!title.equals("")) {
            task.setTitle(title);
        }
        System.out.println("Введите новую дату выполнения задачи либо нажмите Enter");
        String endDate = sc.nextLine();
        if (!endDate.equals("")) {
            task.setEndDate(endDate);
        }
        System.out.println("Введите новое описание задачи либо нажмите Enter");
        String description = sc.nextLine();
        if (!description.equals("")) {
            task.setEndDate(description);
        }
        System.out.println("Изменения внесены!");
    }


    public void getTaskDescription() {
        Task task = searchTask();
        System.out.printf("Описание - %s\n задачи %s\n\n", task.getDescription(), task.getTitle());
    }



    //показ id, имени и даты выполнения всех задач в списке
    public void showTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Список дел пуст!");
        } else {
            System.out.println("Список дел:\n");
            taskList.forEach(task -> System.out.printf("id=%s - %s\n сделать до - %s\n\n", task.getId(), task.getTitle(), task.getEndDate()));
        }
    }


    //удаление задачи по id
    public void deleteTask() {
        Task task = searchTask();
        taskList.remove(task);
        System.out.println("Задача удалена из списка!");
    }



    public static ArrayList<Task> getTrueTaskList() {
        ArrayList<Task> trueTaskList = taskList;
        trueTaskList.removeIf(task -> task.getFlag() == false);
        if (trueTaskList.isEmpty()) {
            System.out.println("Список дел которые выполнены пуст!");
        } else {
            System.out.println("Список выполненных дел:\n");
            trueTaskList.forEach(task -> System.out.printf("id=%s - %s\n сделать до - %s\n\n", task.getId(), task.getTitle(), task.getEndDate()));
        }
        return trueTaskList;
    }



    public static ArrayList<Task> getFalseTaskList() {
        ArrayList<Task> trueTaskList = taskList;
        trueTaskList.removeIf(task -> task.getFlag() == true);
        if (trueTaskList.isEmpty()) {
            System.out.println("Список дел которые выполнены пуст!");
        } else {
            System.out.println("Список выполненных дел:\n");
            trueTaskList.forEach(task -> System.out.printf("id=%s - %s\n сделать до - %s\n\n", task.getId(), task.getTitle(), task.getEndDate()));
        }
        return trueTaskList;
    }

}
