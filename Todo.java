import java.util.Scanner;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Todo {
    public static void main(String[] args) {
        Boolean exitApplication = false;
        Dictionary<String, Boolean> tasks = new Hashtable<String, Boolean>();

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
                            checkTodoList(tasks);
                            System.out.println("Press Enter to return to menu");
                            scanner.nextLine();
                            break;

                        case 2:
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            addNewTask(scanner, tasks);
                            break;
                        case 3:
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

    public static void addNewTask(Scanner scanner, Dictionary<String, Boolean> tasks) {
        System.out.println("Write your task todo (or type 'exit' to finish): ");
        System.out.print("> ");
        String task = scanner.nextLine();
        if ("exit".equalsIgnoreCase(task)) {
            return;
        }
        tasks.put(task, false);
    }

    public static void checkTodoList(Dictionary<String, Boolean> tasks) {
        System.out.println("+-------------------+---------+");
        System.out.println("|        Task       |   Done  |");
        System.out.println("+-------------------+---------+");
    
        Enumeration<String> keys = tasks.keys();
        while (keys.hasMoreElements()) {
            String task = keys.nextElement();
            boolean completed = tasks.get(task);
            String status = completed ? "Yes" : "No";
            System.out.printf("| %-17s | %-7s |\n", task, status);
        }
    
        System.out.println("+-------------------+---------+");
    }
    
    
}
