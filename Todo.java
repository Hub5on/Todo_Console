import java.util.Scanner;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Todo {
    public static void main(String[] args) {
        Boolean exitApplication = false;
        Dictionary<Integer, String> tasks = new Hashtable<Integer, String>();
        Dictionary<Integer, Boolean> taskStatus = new Hashtable<Integer, Boolean>();
        int taskCounter = 1;

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                menu();
                System.out.print("> ");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            checkTodoList(tasks, taskStatus, scanner);
                            System.out.println("Press Enter to return to menu");
                            scanner.nextLine();
                            break;

                        case 2:
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            addNewTask(scanner, tasks, taskStatus, taskCounter);
                            taskCounter++;
                            break;
                        case 3:
                            // Do nothing in this version
                            break;
                        case 4:
                            exitApplication = true;
                            break;
                        default:
                            System.out.println("Bad choice. Enter the correct number.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    scanner.nextLine();
                }
            } while (!exitApplication);
        }
    }

    public static void menu() {
        System.out.println("Menu");
        System.out.println("1. Check your todo list");
        System.out.println("2. Add new todo");
        System.out.println("3. Delete task");
        System.out.println("4. Exit");
    }

    public static void addNewTask(Scanner scanner, Dictionary<Integer, String> tasks, Dictionary<Integer, Boolean> taskStatus, int taskCounter) {
        System.out.println("Write your task todo (or type 'exit' to finish): ");
        System.out.print("> ");
        String task = scanner.nextLine();
        if ("exit".equalsIgnoreCase(task)) {
            return;
        }
        tasks.put(taskCounter, task);
        taskStatus.put(taskCounter, false);
    }

    public static void checkTodoList(Dictionary<Integer, String> tasks, Dictionary<Integer, Boolean> taskStatus, Scanner scanner) {
        System.out.println("+---+-------------------+---------+");
        System.out.println("| # |        Task       |   Done  |");
        System.out.println("+---+-------------------+---------+");

        Enumeration<Integer> keys = tasks.keys();
        while (keys.hasMoreElements()) {
            int taskNumber = keys.nextElement();
            String task = tasks.get(taskNumber);
            boolean completed = taskStatus.get(taskNumber);
            String status = completed ? "Yes" : "No";
            System.out.printf("| %-2d| %-17s | %-7s |\n", taskNumber, task, status);
        }

        System.out.println("+---+-------------------+---------+");

        System.out.println("Enter the task number you want to edit (or type 'exit' to finish editing): ");
        System.out.print("> ");
        int taskNumberToEdit = scanner.nextInt();
        scanner.nextLine();
        
        if (tasks.get(taskNumberToEdit) != null) {
            System.out.println("Enter the new status (Yes/No): ");
            System.out.print("> ");
            String newStatus = scanner.nextLine();
            if ("Yes".equalsIgnoreCase(newStatus)) {
                taskStatus.put(taskNumberToEdit, true);
            } else if ("No".equalsIgnoreCase(newStatus)) {
                taskStatus.put(taskNumberToEdit, false);
            } else {
                System.out.println("Invalid status. Task status remains unchanged.");
            }
        } else if (taskNumberToEdit != -1) {
            System.out.println("Task number not found. Task status remains unchanged.");
        }
    }
}
