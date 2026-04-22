import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FitnessLog fitnessLog = new FitnessLog();

        // Input one workout
        System.out.println("=== Add Workout ===");
        System.out.print("Workout type: ");
        String workoutType = scanner.nextLine();
        System.out.print("Duration (minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Calories burned: ");
        int calories = scanner.nextInt();
        scanner.nextLine(); // consume newline

        WorkoutEntry workout = new WorkoutEntry(workoutType, duration, calories);
        fitnessLog.addWorkout(workout);

        // Input one macro entry
        System.out.println("\n=== Add Macro Entry ===");
        System.out.print("Meal name: ");
        String mealName = scanner.nextLine();
        System.out.print("Protein (g): ");
        int protein = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Carbs (g): ");
        int carbs = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fat (g): ");
        int fat = scanner.nextInt();
        scanner.nextLine();

        MacroEntry macro = new MacroEntry(mealName, protein, carbs, fat);
        fitnessLog.addMacro(macro);

        // Input one sleep entry
        System.out.println("\n=== Add Sleep Entry ===");
        System.out.print("Hours slept: ");
        double hours = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Quality (Good/Fair/Poor): ");
        String quality = scanner.nextLine();
        System.out.print("Date: ");
        String date = scanner.nextLine();

        SleepEntry sleep = new SleepEntry(hours, quality, date);
        fitnessLog.addSleepEntry(sleep);

        // Print back to confirm
        System.out.println("\n=== CONFIRMATION ===");
        System.out.println("Workout: " + workout.getType() + ", " + workout.getDurationMinutes() + " min, " + workout.getCaloriesBurned() + " cal");
        System.out.println("Macro: " + macro.getMealName() + " - P:" + macro.getProtein() + "g C:" + macro.getCarbs() + "g F:" + macro.getFat() + "g");
        System.out.println("Sleep: " + sleep.getHours() + " hours, " + sleep.getQuality() + ", " + sleep.getDate());

        scanner.close();
    }
}
