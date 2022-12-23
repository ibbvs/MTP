import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

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


    //вынес в отдельный метод поиск в массиве по id, с исключениями, если вводится не число, число-id которого нет в массиве)
    public static Task searchTask() throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("Введите id задачи - ");
            try {
                String id = sc.next();
                if (id.equals("-1"))
                    flag = false;
                else {
                    Task task = taskList.get(Integer.parseInt(id) - 1);
                    flag = false;
                    return task;
                }
            } catch (InputMismatchException h) {
                System.out.println("Введите число либо -1 для выхода");
            } catch (IndexOutOfBoundsException ae) {
                System.out.println("Неккоректный id, повторите попытку либо введите -1 для выхода");
            } catch (NumberFormatException e) {
                System.out.println("Введите число либо -1 для выхода");
            }
        }
        return null;
    }



    //добавление в список
    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Задача добавлена в список дел!");
    }



    // пункт 2 - внесение изменений в задачу
    // сначало вызывается метод searchTask, проверяет корректность id, потом идет изменения найденной задачи
    // флаг выполнения [выполнено, невыполнено], изменение имени, даты выполнения, описания
    public void changeTask() throws IOException {
        Scanner sc = new Scanner(System.in);

        Task task = searchTask();
        if (task != null) {
            System.out.println("Хотите отметить задание как выполненное? ['да', 'нет']");
            String answer = sc.nextLine();
            if (answer.equals("да"))
                task.setFlag(true);
            else if (answer.equals("нет"))
                task.setFlag(false);
            else
                System.out.println("Некорректный ввод, задача отмечена как невыполненная");
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
    }



    // пункт 9 - простой метод, выводит только описание задачи.
    public void getTaskDescription() throws IOException {
        Task task = searchTask();
        if (task != null) {
            System.out.printf("Описание - %s\n задачи - %s\n\n", task.getDescription(), task.getTitle());
        }
    }



    //показ id, имени и даты выполнения всех задач в списке через forEach
    public void showTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Список дел пуст!");
        } else {
            System.out.println("Список дел:\n");
            taskList.forEach(System.out::println);
        }
    }



    //удаление задачи по id
    public void deleteTask() throws IOException {
        Task task = searchTask();
        if (task != null) {
            taskList.remove(task);
            System.out.println("Задача удалена из списка!");
        }
    }


    // пункт 5. Алгоритм
    // клонируется основной массив с задачами, которые туда добавлены
    // через lambda и фильтр функцию фильтруется копия массива, фильтр работает через свойство Task, а именно flag. Если flag = true, задача выполнена, false - невыполнена
    public static ArrayList<Task> getTrueTaskList() {
        // клонирование taskList'а
        ArrayList<Task> trueTaskList = new ArrayList<Task>(taskList.size());
        for (Task task : taskList) {
            trueTaskList.add(task);
        }
        trueTaskList.removeIf(task -> task.getFlag() == false); // фильтр по флагу
        if (trueTaskList.isEmpty()) {
            System.out.println("Список дел которые выполнены пуст!");
        } else {
            System.out.println("Список выполненных дел:\n");
            trueTaskList.forEach(System.out::println);
        }
        return trueTaskList;
    }


    // получение невыполненных заданий
    // пункт 6. Алгоритм тот же самый, меняется только значение flag'а
    public static ArrayList<Task> getFalseTaskList() {
        ArrayList<Task> falseTaskList = new ArrayList<Task>(taskList.size());
        for (Task task : taskList) {
            falseTaskList.add(task);
        }
        falseTaskList.removeIf(task -> task.getFlag() == true); // здесь
        if (falseTaskList.isEmpty()) {
            System.out.println("Список дел которые  НЕвыполнены пуст!");
        } else {
            System.out.println("Список НЕвыполненных дел:\n");
            falseTaskList.forEach(System.out::println);
        }
        return falseTaskList;
    }



    // фильтр по дате выполнения
    // пункт 7, в который входит показ всех задач, выполненных и невыполненных через switch
    // Алгоритм
    // так же копируется основной массив с тасками
    // но фильтруется уже по дате выполнения, сравнивается дата выполнения таска и введенного пользователем
    // и дальше через switch в каждом кейсе свой фильтр на flag; выводит либо все задачи, либо выполненные, либо невыполненные
    // тестил, вроде работает, но уверен что можно легко сломать
    public static ArrayList<Task> getTaskListEndDate(String number) {
        // клонирование taskList'а
        ArrayList<Task> trueTaskList = new ArrayList<Task>(taskList.size());
        for (Task task : taskList) {
            trueTaskList.add(task);
        }


        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату выполнения по которой надо отфильтровать");
        String date = sc.nextLine();
        boolean flag = true;
        // фильтр по флагу даты выполнения
        trueTaskList.removeIf(task -> task.getEndDate().equals(date));
        while (flag) {
            switch (number) {
                case "4":
                    trueTaskList.forEach(System.out::println);
                    flag = false;
                    break;
                case "5":
                    trueTaskList.removeIf(task -> task.getFlag() == false);
                    if (trueTaskList.isEmpty()) {
                        System.out.printf("Список дел на дату - '%s' которые выполнены пуст!\n", date);
                    } else {
                        System.out.printf("Список выполненных дел на дату - '%s':\n", date);
                        trueTaskList.forEach(System.out::println);
                    }
                    break;
                case "6":
                    trueTaskList.removeIf(task -> task.getFlag() == true);
                    if (trueTaskList.isEmpty()) {
                        System.out.printf("Список дел на дату - '%s' которые НЕвыполнены пуст!\n", date);
                    } else {
                        System.out.printf("Список НЕвыполненных дел на дату - '%s':\n", date);
                        trueTaskList.forEach(System.out::println);
                    }
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("Ошибка ввода, попробуйте еще раз либо введите '0' для выхода");
                    break;
            }
        }
        return trueTaskList;
    }



    // фильтр по дате создания
    //пункт 8
    // отличается от пункта 7 только изменненым фильтром, на дату создания, которая создается автоматически с созданием объекта Task
    public static ArrayList<Task> getTaskListStartDate(String number) {
        // клонирование taskList'а
        ArrayList<Task> trueTaskList = new ArrayList<Task>(taskList.size());
        for (Task task : taskList) {
            trueTaskList.add(task);
        }


        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату создания по которой надо отфильтровать");
        String date = sc.nextLine();
        boolean flag = true;
        // фильтр по флагу даты создания
        trueTaskList.removeIf(task -> task.getEndDate().equals(date));
        switch (number) {
            case "4":
                trueTaskList.forEach(System.out::println);
                break;
            case "5":
                trueTaskList.removeIf(task -> task.getFlag() == false);
                if (trueTaskList.isEmpty()) {
                    System.out.printf("Список дел на дату - '%s' которые выполнены пуст!\n", date);
                } else {
                    System.out.printf("Список выполненных дел на дату - '%s':\n", date);
                    trueTaskList.forEach(System.out::println);
                }
                break;
            case "6":
                trueTaskList.removeIf(task -> task.getFlag() == true);
                if (trueTaskList.isEmpty()) {
                    System.out.printf("Список дел на дату - '%s' которые НЕвыполнены пуст!\n", date);
                } else {
                    System.out.printf("Список НЕвыполненных дел на дату - '%s':\n", date);
                    trueTaskList.forEach(System.out::println);
                }
                break;
            case "0":
                flag = false;
                break;
            default:
                System.out.println("Ошибка ввода, попробуйте еще раз либо введите '0' для выхода");
                break;
        }
        return trueTaskList;
    }


}
