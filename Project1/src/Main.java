import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        TaskService taskList = new TaskService(new ArrayList<>());
        System.out.println("Планировщик дел v. -0.1\n");
        System.out.println("В данном приложении реализованны следующие функции:");
        System.out.println("1 - Создать задание\n2 - Редактировать задание\n3 - Удалить задание");
        System.out.println("4 - Просмотреть список ВСЕХ заданий\n5 - Просмотреть список ВЫПОЛНЕННЫХ заданий\n6 - Просмотреть список НЕВЫПОЛНЕННЫХ заданий");
        System.out.println("7 - Пункты 4-6 на конкретную дату ВЫПОЛНЕНИЯ\n8 - Пункты 4-6 на конкретную дату СОЗДАНИЯ\n9 - Просмотреть детальную информацию о задании");
        System.out.println("0 - Закрыть приложение");
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
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
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
        }
    }
}



/*
while (true) {
            System.out.print("Выберите что хотите сделать: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Ошибка ввода, попробуйте еще раз");
                    break;
 */