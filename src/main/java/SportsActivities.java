import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SportsActivities {

    private final HashMap<Double, String> activities = new HashMap<>();
    private double total;
    Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    String[] options = {"0. Exit",
            "1. Log new activity.",
            "2. View logged activities.",
            "3. View total time spent."};


    // add given activity and time spent
    public void logTime(String activity, double time) {
        this.activities.put(time, activity);
    };

    // displaying each activity and time spent
    public void viewActivities() {
        activities.forEach((key, value) -> {
            System.out.println("Activity: " + value + ", time spent: " + key);
        });
    }

    // displays total time spent on the activities user has logged
    public void getTotalTime() {
        activities.forEach((key, value) -> {
            this.total += key;
        });
        System.out.println("Total time spent: " + this.total);
        this.total = 0.0;
    }

    // displays options for users and returns the user input
    public int getUserChoice(String[] options) {
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    // runs the sportsApp until user exits
    public void run() {
        try {
            do {
                switch (getUserChoice(options)) {
                    case 0:
                        running = false;
                        break;
                    case 1:
                        System.out.print("Give activity to log: ");
                        String activity = scanner.nextLine();
                        System.out.print("Give time spent:" );
                        double time = scanner.nextDouble();
                        logTime(activity, time);
                        break;
                    case 2:
                        viewActivities();
                        break;
                    case 3:
                        getTotalTime();
                        break;
                }
            } while (running);

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number");
        }
    }

    public HashMap<Double, String> getActivities() {
        return activities;
    }

    public static void main(String[] args) {
        new SportsActivities().run();
    }
}
