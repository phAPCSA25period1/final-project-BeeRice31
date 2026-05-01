import java.util.Scanner;

/**
 * Main application class for the Fitness Tracker program.
 * Runs the console-based interface for users to set goals and log daily
 * activity.
 */
public class App {

        /**
         * Prompts the user for an integer input and repeats until a valid integer is
         * entered.
         * 
         * @param prompt the message to display to the user
         * @param input  the Scanner object to read input from
         * @return a valid integer entered by the user
         */
        private static int getValidInt(String prompt, Scanner input) {
                while (true) {
                        System.out.print(prompt);
                        if (input.hasNextInt()) {
                                int value = input.nextInt();
                                input.nextLine();
                                return value;
                        } else {
                                System.out.println("  Invalid input. Please enter a whole number.");
                                input.nextLine();
                        }
                }
        }

        /**
         * Prompts the user for a double input and repeats until a valid double is
         * entered.
         * 
         * @param prompt the message to display to the user
         * @param input  the Scanner object to read input from
         * @return a valid double entered by the user
         */
        private static double getValidDouble(String prompt, Scanner input) {
                while (true) {
                        System.out.print(prompt);
                        if (input.hasNextDouble()) {
                                double value = input.nextDouble();
                                input.nextLine();
                                return value;
                        } else {
                                System.out.println("  Invalid input. Please enter a number.");
                                input.nextLine();
                        }
                }
        }

        /**
         * Prints a styled section header to the console.
         * 
         * @param title the title to display in the header
         */
        private static void printHeader(String title) {
                System.out.println("\n+======================================+");
                System.out.printf("|  %-36s|%n", title);
                System.out.println("+======================================+");
        }

        /**
         * Prints a divider line to the console.
         */
        private static void printDivider() {
                System.out.println("  ----------------------------------------");
        }

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
                printHeader("FITNESS TRACKER - SETUP");
                System.out.print("  Enter your name: ");
                String name = input.nextLine();

                System.out.print("  Enter your fitness goal: ");
                String fitnessGoals = input.nextLine();

                User user = new User(name, fitnessGoals);
                WeeklyTracker weeklyTracker = new WeeklyTracker();

                System.out.println("\n  Set your daily goals:");
                user.setProteinGoal(getValidInt("  > Protein goal (grams): ", input));
                user.setSleepGoal(getValidInt("  > Sleep goal (hours): ", input));
                user.setWorkoutGoal(getValidInt("  > Workout goal (sessions): ", input));

                printHeader("YOUR GOALS");
                System.out.println("  Name:     " + user.getName());
                System.out.println("  Goal:     " + user.getFitnessGoals());
                printDivider();
                System.out.println("  Protein:  " + user.getProteinGoal() + "g per day");
                System.out.println("  Sleep:    " + user.getSleepGoal() + " hours per night");
                System.out.println("  Workouts: " + user.getWorkoutGoal() + " sessions per day");

                // ========== PART 2: LOG DAILY ACTIVITY ==========
                printHeader("LOG TODAY'S ACTIVITY");

                FitnessLog log = new FitnessLog();

                // Log workouts
                System.out.println("  [ WORKOUTS ]");
                String logAnother = "yes";
                while (logAnother.equalsIgnoreCase("yes")) {
                        System.out.println("\n  What type of exercise?");
                        System.out.println("    1. Lifting");
                        System.out.println("    2. Cardio");
                        int exerciseType = getValidInt("  > Enter 1 or 2: ", input);

                        if (exerciseType == 1) {
                                System.out.print("  > Exercise name: ");
                                String exerciseName = input.nextLine();
                                int sets = getValidInt("  > Sets: ", input);
                                int reps = getValidInt("  > Reps: ", input);
                                int duration = getValidInt("  > Duration (minutes): ", input);

                                log.addWorkout(new WorkoutEntry(exerciseName, duration, sets, reps));
                                System.out.println("  >> Lifting session logged!");

                        } else if (exerciseType == 2) {
                                System.out.println("\n  What type of cardio?");
                                System.out.println("    1. Running");
                                System.out.println("    2. Cycling");
                                System.out.println("    3. Swimming");
                                System.out.println("    4. Other");
                                int cardioType = getValidInt("  > Enter 1-4: ", input);

                                String cardioName;
                                switch (cardioType) {
                                        case 1:
                                                cardioName = "Running";
                                                break;
                                        case 2:
                                                cardioName = "Cycling";
                                                break;
                                        case 3:
                                                cardioName = "Swimming";
                                                break;
                                        default:
                                                System.out.print("  > Enter cardio type: ");
                                                cardioName = input.nextLine();
                                                break;
                                }

                                int duration = getValidInt("  > Duration (minutes): ", input);
                                log.addWorkout(new WorkoutEntry(cardioName, duration, 0, 0));
                                System.out.println("  >> Cardio session logged!");

                        } else {
                                System.out.println("  Invalid choice. Please enter 1 or 2.");
                        }

                        System.out.print("\n  Log another workout? (yes/no): ");
                        logAnother = input.nextLine();
                }

                // Log meals
                printDivider();
                System.out.println("  [ MEALS ]");
                logAnother = "yes";
                while (logAnother.equalsIgnoreCase("yes")) {
                        System.out.print("\n  > Meal name: ");
                        String mealName = input.nextLine();
                        int protein = getValidInt("  > Protein (grams): ", input);
                        int carbs = getValidInt("  > Carbs (grams): ", input);
                        int fat = getValidInt("  > Fat (grams): ", input);

                        log.addMacro(new MacroEntry(mealName, protein, carbs, fat));
                        System.out.println("  >> Meal logged!");

                        System.out.print("\n  Log another meal? (yes/no): ");
                        logAnother = input.nextLine();
                }

                // Log sleep
                printDivider();
                System.out.println("  [ SLEEP ]");
                double sleepHours = getValidDouble("\n  > Hours of sleep: ", input);
                System.out.print("  > Sleep quality (Good/Fair/Poor): ");
                String sleepQuality = input.nextLine();
                SleepEntry sleep = new SleepEntry(sleepHours, sleepQuality, "2026-04-27");
                log.addSleepEntry(sleep);
                System.out.println("  >> Sleep logged!");

                // ========== PART 3: DISPLAY SUMMARY ==========
                printHeader("TODAY'S SUMMARY");

                System.out.println("  [ WORKOUTS ]");
                for (WorkoutEntry w : log.getWorkouts()) {
                        if (w.getSets() == 0) {
                                System.out.println("  - " + w.getType() + " (cardio) -- " +
                                                w.getDurationMinutes() + " min");
                        } else {
                                System.out.println("  - " + w.getType() + " -- " +
                                                w.getSets() + " sets x " +
                                                w.getReps() + " reps, " +
                                                w.getDurationMinutes() + " min");
                        }
                }

                printDivider();
                System.out.println("  [ MEALS ]");
                int totalCalories = 0;
                for (MacroEntry m : log.getMacros()) {
                        System.out.println("  - " + m.getMealName() + " -- " +
                                        m.getProtein() + "g protein, " +
                                        m.getCarbs() + "g carbs, " +
                                        m.getFat() + "g fat");
                        totalCalories += m.calculateCalories();
                }
                System.out.println("  Total Calories: " + totalCalories + " cal");

                printDivider();
                System.out.println("  [ SLEEP ]");
                System.out.println("  - " + sleep.getHours() + " hours -- " + sleep.getQuality());

                // ========== PART 4: GOAL SCORE ==========
                GoalTracker tracker = new GoalTracker(user, log);

                printHeader("GOAL SCORE BREAKDOWN");

                int totalWorkouts = log.getWorkouts().size();
                double workoutScore = Math.min(((double) totalWorkouts / user.getWorkoutGoal()) * 100, 100.0);
                System.out.printf("  Workouts: %d/%d sessions = %.1f%%%n",
                                totalWorkouts, user.getWorkoutGoal(), workoutScore);

                int totalProtein = 0;
                for (MacroEntry m : log.getMacros()) {
                        totalProtein += m.getProtein();
                }
                double macroScore = Math.min(((double) totalProtein / user.getProteinGoal()) * 100, 100.0);
                System.out.printf("  Protein:  %dg/%dg = %.1f%%%n",
                                totalProtein, user.getProteinGoal(), macroScore);

                double totalSleep = 0;
                for (SleepEntry s : log.getSleepEntries()) {
                        totalSleep += s.getHours();
                }
                double sleepScore = Math.min((totalSleep / user.getSleepGoal()) * 100, 100.0);
                System.out.printf("  Sleep:    %.1fh/%.1fh = %.1f%%%n",
                                totalSleep, (double) user.getSleepGoal(), sleepScore);

                printDivider();
                int dailyScore = tracker.calcDailyScore();
                weeklyTracker.logDay(
                                (int) Math.round(workoutScore),
                                (int) Math.round(macroScore),
                                (int) Math.round(sleepScore));
                System.out.println("\n  DAILY PROGRESS SCORE: " + dailyScore + "%");

                if (dailyScore == 100) {
                        System.out.println("  ** Perfect day! You hit all your goals!");
                } else if (dailyScore >= 75) {
                        System.out.println("  >> Great work! You're close to hitting all your goals.");
                } else if (dailyScore >= 50) {
                        System.out.println("  -> Good effort. Keep pushing tomorrow.");
                } else {
                        System.out.println("  ^ Room to improve. You've got this!");
                }

                System.out.println("\n+======================================+\n");

                weeklyTracker.printWeeklySummary();

                input.close();
        }
}
