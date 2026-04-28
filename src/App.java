import java.util.Scanner;

/**
 * Main application class for the Fitness Tracker program.
 * Runs the console-based interface for users to set goals and log daily
 * activity.
 */
public class App {

        /**
         * Entry point for the Fitness Tracker application.
         * Guides the user through setting goals, logging daily activity,
         * and displaying a daily progress score.
         * 
         * @param args command-line arguments (not used)
         */
        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);

                // ========== PART 1: GET USER GOALS ==========
                System.out.println("=== FITNESS TRACKER - SET UP ===");
                System.out.print("Enter your name: ");
                String name = input.nextLine();

                System.out.print("Enter your fitness goal: ");
                String fitnessGoals = input.nextLine();

                // Create user with entered goals
                User user = new User(name, fitnessGoals);

                // Prompt for protein goal
                System.out.print("Enter your daily protein goal (grams): ");
                user.setProteinGoal(input.nextInt());

                // Prompt for sleep goal
                System.out.print("Enter your daily sleep goal (hours): ");
                user.setSleepGoal(input.nextInt());

                // Prompt for workout goal
                System.out.print("Enter your weekly workout goal (number of workouts): ");
                user.setWorkoutGoal(input.nextInt());
                input.nextLine(); // consume newline

                System.out.println("\n=== YOUR GOALS ===");
                System.out.println("Name: " + user.getName());
                System.out.println("Fitness Goal: " + user.getFitnessGoals());
                System.out.println("Protein: " + user.getProteinGoal() + "g");
                System.out.println("Sleep: " + user.getSleepGoal() + " hours");
                System.out.println("Workouts: " + user.getWorkoutGoal() + " per week");

                // ========== PART 2: LOG DAILY ACTIVITY ==========
                System.out.println("\n=== LOG TODAY'S ACTIVITY ===");

                // Create fitness log
                FitnessLog log = new FitnessLog();

                // Log workout
                System.out.print("Enter exercise name: ");
                String exerciseName = input.nextLine();

                System.out.print("Enter duration (minutes): ");
                int duration = input.nextInt();

                System.out.print("Enter number of sets: ");
                int sets = input.nextInt();

                System.out.print("Enter number of reps: ");
                int reps = input.nextInt();
                input.nextLine(); // consume newline

                WorkoutEntry workout = new WorkoutEntry(exerciseName, duration, sets, reps);
                log.addWorkout(workout);

                // Log macros
                System.out.print("\nEnter meal name: ");
                String mealName = input.nextLine();

                System.out.print("Enter protein (grams): ");
                int protein = input.nextInt();

                System.out.print("Enter carbs (grams): ");
                int carbs = input.nextInt();

                System.out.print("Enter fat (grams): ");
                int fat = input.nextInt();
                input.nextLine(); // consume newline

                MacroEntry macro = new MacroEntry(mealName, protein, carbs, fat);
                log.addMacro(macro);

                // Log sleep
                System.out.print("\nEnter hours of sleep: ");
                double sleepHours = input.nextDouble();
                input.nextLine(); // consume newline

                System.out.print("Enter sleep quality (Good/Fair/Poor): ");
                String sleepQuality = input.nextLine();

                SleepEntry sleep = new SleepEntry(sleepHours, sleepQuality, "2026-04-27");
                log.addSleepEntry(sleep);

                // ========== PART 3: DISPLAY DATA AND CALCULATE SCORE ==========
                System.out.println("\n=== TODAY'S LOGGED DATA ===");
                System.out.println("Workout: " + workout.getType() + " - " +
                                workout.getDurationMinutes() + " min, " +
                                workout.getSets() + " sets, " +
                                workout.getReps() + " reps");

                System.out.println("Meal: " + macro.getMealName() + " - " +
                                macro.getProtein() + "g protein, " +
                                macro.getCarbs() + "g carbs, " +
                                macro.getFat() + "g fat");

                System.out.println("Sleep: " + sleep.getHours() + " hours (" +
                                sleep.getQuality() + ")");

                // Create GoalTracker and calculate daily score
                GoalTracker tracker = new GoalTracker(user, log);

                System.out.println("\n=== GOAL SCORE CALCULATION ===");

                // Calculate individual scores
                int totalWorkouts = log.getWorkouts().size();
                double workoutScore = Math.min(((double) totalWorkouts / user.getWorkoutGoal()) * 100, 100.0);
                System.out.println("Workout Score: " + totalWorkouts + "/" + user.getWorkoutGoal() + " workouts = " +
                                String.format("%.1f", workoutScore) + "%");

                int totalProtein = 0;
                for (MacroEntry m : log.getMacros()) {
                        totalProtein += m.getProtein();
                }
                double macroScore = Math.min(((double) totalProtein / user.getProteinGoal()) * 100, 100.0);
                System.out.println("Macro Score: " + totalProtein + "/" + user.getProteinGoal() + "g protein = " +
                                String.format("%.1f", macroScore) + "%");

                double totalSleep = 0;
                for (SleepEntry s : log.getSleepEntries()) {
                        totalSleep += s.getHours();
                }
                double sleepScore = Math.min((totalSleep / user.getSleepGoal()) * 100, 100.0);
                System.out.println("Sleep Score: " + totalSleep + "/" + user.getSleepGoal() + "h sleep = " +
                                String.format("%.1f", sleepScore) + "%");

                // Calculate total calories: protein=4 cal/g, carbs=4 cal/g, fat=9 cal/g
                int totalCalories = 0;
                for (MacroEntry m : log.getMacros()) {
                        totalCalories += m.calculateCalories();
                }
                System.out.println("\nTotal Calories: " + totalCalories + " cal");

                // Calculate and display daily progress score
                int dailyScore = tracker.calcDailyScore();
                System.out.println("\n=== DAILY PROGRESS SCORE ===");
                System.out.println("Your daily progress score: " + dailyScore + "%");

                input.close();
        }
}
