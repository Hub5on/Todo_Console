import java.util.Scanner;

public class Todo {
    public static void main(String[] args) {
        
        Boolean exitAplication = false;
        int choice = 0;
        

        do{
            try(Scanner scanner = new Scanner(System.in)){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                menu();
                System.out.print("> ");
                try{
                    choice = scanner.nextInt();
                }catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                } 
            }
            switch (choice) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    exitAplication = true;
                    break;
            }
            
            
        }while(!exitAplication);
        
    }

    public static void menu() {
        System.out.println("Menu");
        System.out.println("1. Check your todo list");
        System.out.println("2. Add new todo");
        System.out.println("3. Delete task");
        System.out.println("4. Exit");
    }
}