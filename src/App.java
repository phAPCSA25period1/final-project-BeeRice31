public class App {
    public static void main(String[] args) {
        // Create user with default goals
        User user = new User("Alex", "Build fitness");
        System.out.println("User: " + user.getName());
        System.out.println("Goals: Calories=" + user.getCalorieGoal() +
                ", Protein=" + user.getProteinGoal() +
                "g, Sleep=" + user.getSleepGoal() +
                "h, Workouts=" + user.getWorkoutGoal());

        // Create fitness log and add sample data
        FitnessLog log = new FitnessLog();

        // Add workout: 1000 calories (goal is 2000)
        WorkoutEntry workout1 = new WorkoutEntry("Running", 60, 600);
        WorkoutEntry workout2 = new WorkoutEntry("Strength", 45, 400);
        log.addWorkout(workout1);
        log.addWorkout(workout2);

        // Add macro entries: 180g protein (goal is 150g)
        MacroEntry macro1 = new MacroEntry("Breakfast", 30, 50, 10);
        MacroEntry macro2 = new MacroEntry("Lunch", 60, 80, 20);
        MacroEntry macro3 = new MacroEntry("Dinner", 90, 100, 30);
        log.addMacro(macro1);
        log.addMacro(macro2);
        log.addMacro(macro3);

        // Add sleep entry: 8 hours (goal is 8h)
        SleepEntry sleep = new SleepEntry(8.0, "Good", "2026-04-23");
        log.addSleepEntry(sleep);

        // Create GoalTracker and calculate daily score
        GoalTracker tracker = new GoalTracker(user, log);

        System.out.println("\n=== TODAY'S DATA ===");
        System.out.println("Workouts: " + log.getWorkouts().size());
        int totalCalories = 0;
        for (WorkoutEntry w : log.getWorkouts()) {
            System.out.println("  - " + w.getType() + ": " + w.getCaloriesBurned() + " cal");
            totalCalories += w.getCaloriesBurned();
        }
        System.out.println("  Total Calories: " + totalCalories);

        int totalProtein = 0;
        for (MacroEntry m : log.getMacros()) {
            System.out.println("  - " + m.getMealName() + ": " + m.getProtein() + "g protein");
            totalProtein += m.getProtein();
        }
        System.out.println("  Total Protein: " + totalProtein + "g");

        for (SleepEntry s : log.getSleepEntries()) {
            System.out.println("  Sleep: " + s.getHours() + " hours (" + s.getQuality() + ")");
        }

        System.out.println("\n=== GOAL SCORE CALCULATION ===");
        double workoutScore = ((double) totalCalories / user.getCalorieGoal()) * 100;
        workoutScore = Math.min(workoutScore, 100.0);
        System.out.println("Workout Score: " + totalCalories + "/" + user.getCalorieGoal() + " cal = "
                + String.format("%.1f", workoutScore) + "%");

        double macroScore = ((double) totalProtein / user.getProteinGoal()) * 100;
        macroScore = Math.min(macroScore, 100.0);
        System.out.println("Macro Score: " + totalProtein + "/" + user.getProteinGoal() + "g = "
                + String.format("%.1f", macroScore) + "%");

        double sleepScore = (8.0 / user.getSleepGoal()) * 100;
        sleepScore = Math.min(sleepScore, 100.0);
        System.out
                .println("Sleep Score: 8.0/" + user.getSleepGoal() + "h = " + String.format("%.1f", sleepScore) + "%");

        int dailyScore = tracker.calcDailyScore();
        System.out.println("\n=== DAILY SCORE ===");
        System.out.println("Final Score: " + dailyScore + "%");
    }
}
