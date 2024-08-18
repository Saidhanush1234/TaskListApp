
 
import java.util.ArrayList;
import java.util.Scanner;

public class TaskListApp {

    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    listTasks();
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nTask List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // clear invalid input
        }
        return scanner.nextInt();
    }

    private static void addTask() {
        System.out.print("Enter the task description: ");
        scanner.nextLine(); // consume newline
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }

        listTasks();
        System.out.print("Enter the number of the task to remove: ");
        int taskNumber = getUserChoice() - 1;

        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            tasks.remove(taskNumber);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Task List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}


