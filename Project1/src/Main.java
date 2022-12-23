import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/*
Никак не ограничивал, не фильтровал ДАТУ ВЫПОЛНЕНИЯ задачи.
То есть, можно ввести что-угодно, ['25.12.2022', 'До Среды', etc]
Либо оставить пустым и через операцию изменения уже добавить эту дату.
 */



public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        TaskService taskList = new TaskService(new ArrayList<>());
        System.out.println("\n\nПланировщик дел v. -0.1\n");
        System.out.println("В данном приложении реализованны следующие функции:");
        showTC();
        while (flag) {
            System.out.print("Выберите действие - ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    Task task1 = TaskService.createTask();
                    taskList.addTask(task1);
                    break;
                case "2":
                    taskList.changeTask();
                    break;
                case "3":
                    taskList.deleteTask();
                    break;
                case "4":
                    taskList.showTasks();
                    break;
                case "5":
                    ArrayList<Task> trueTaskList = taskList.getTrueTaskList();
                    break;
                case "6":
                    ArrayList<Task> falseTaskList = taskList.getFalseTaskList();
                    break;
                case "7":
                    System.out.println("4 - Просмотреть список ВСЕХ заданий\n5 - Просмотреть список ВЫПОЛНЕННЫХ заданий\n6 - Просмотреть список НЕВЫПОЛНЕННЫХ заданий\n");
                    System.out.println("Фильтр по Дате выполнения. Для начала выберите действие - ");
                    String choice7 = sc.nextLine();
                    TaskService.getTaskListEndDate(choice7);
                    break;
                case "8":
                    System.out.println("4 - Просмотреть список ВСЕХ заданий\n5 - Просмотреть список ВЫПОЛНЕННЫХ заданий\n6 - Просмотреть список НЕВЫПОЛНЕННЫХ заданий\n");
                    System.out.println("Фильтр по Дате создания. Для начала выберите действие - ");
                    String choice8 = sc.nextLine();
                    TaskService.getTaskListStartDate(choice8);
                    break;
                case "9":
                    taskList.getTaskDescription();
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("Ошибка ввода, попробуйте еще раз");
                    break;
            }
            showTC();
        }
    }




    public static void showTC() {
        System.out.println("\n1 - Создать задание\n2 - Редактировать задание\n3 - Удалить задание");
        System.out.println("4 - Просмотреть список ВСЕХ заданий\n5 - Просмотреть список ВЫПОЛНЕННЫХ заданий\n6 - Просмотреть список НЕВЫПОЛНЕННЫХ заданий");
        System.out.println("7 - Пункты 4-6 на конкретную дату ВЫПОЛНЕНИЯ\n8 - Пункты 4-6 на конкретную дату СОЗДАНИЯ\n9 - Просмотреть детальную информацию о задании");
        System.out.println("0 - Закрыть приложение\n");
    }
}
