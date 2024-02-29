import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String name;
    private String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

public class TaskManagerApp {
    private List<Task> tasks;
    private Scanner scanner;

    public TaskManagerApp() {
        this.tasks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        TaskManagerApp app = new TaskManagerApp();
        app.run();
    }

    public void run() {
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    saveTask();
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    launchSpecificTask();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command. Please enter a valid command.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nCommand Menu:");
        System.out.println("1. Save Task");
        System.out.println("2. List Tasks");
        System.out.println("3. Update Specific Task");
        System.out.println("4. Delete Specific Task");
        System.out.println("5. Launch Specific Task");
        System.out.println("0. Exit");
        System.out.println("Enter command:");
    }

    private void saveTask() {
        System.out.println("Enter Task name:");
        String name = scanner.nextLine();
        System.out.println("Enter Task description:");
        String description = scanner.nextLine();

        Task newTask = new Task(name, description);
        tasks.add(newTask);
        System.out.println("Task saved successfully.");
    }

    private void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Task List:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private void updateTask() {
        System.out.println("Enter the name of the Task to update:");
        String taskName = scanner.nextLine();

        Task existingTask = findTaskByName(taskName);

        if (existingTask == null) {
            System.out.println("Task does not exist.");
            return;
        }

        System.out.println("Enter new Task description:");
        String newDescription = scanner.nextLine();

        existingTask = new Task(existingTask.getName(), newDescription);
        System.out.println("Task updated successfully.");
    }

    private void deleteTask() {
        System.out.println("Enter the name of the Task to delete:");
        String taskName = scanner.nextLine();

        Task existingTask = findTaskByName(taskName);

        if (existingTask == null) {
            System.out.println("Task does not exist.");
            return;
        }

        tasks.remove(existingTask);
        System.out.println("Task deleted successfully.");
    }

    private void launchSpecificTask() {
        System.out.println("Enter the name of the Task to launch:");
        String taskName = scanner.nextLine();

        Task existingTask = findTaskByName(taskName);

        if (existingTask == null) {
            System.out.println("Task does not exist.");
        } else {
            System.out.println("Launching Task: " + existingTask);
        }
    }

    private Task findTaskByName(String name) {
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }
}
