public class GoalTracker {
    private User user;
    private FitnessLog log;

    public GoalTracker(User user, FitnessLog log) {
        this.user = user;
        this.log = log;
    }

    public int calcDailyScore() {
        // Calculate score for each category (each worth 33%)
        double workoutScore = calcWorkoutScore();
        double macroScore = calcMacroScore();
        double sleepScore = calcSleepScore();

        // Average the three categories
        double dailyScore = (workoutScore + macroScore + sleepScore) / 3.0;

        // Return as integer percentage (0-100)
        return (int) Math.round(dailyScore);
    }

    private double calcWorkoutScore() {
        // Calculate total calories burned today
        int totalCaloriesBurned = 0;
        for (WorkoutEntry workout : log.getWorkouts()) {
            totalCaloriesBurned += workout.getCaloriesBurned();
        }

        // Score based on calorie goal
        double score = ((double) totalCaloriesBurned / user.getCalorieGoal()) * 100;

        // Cap at 100%
        return Math.min(score, 100.0);
    }

    private double calcMacroScore() {
        // Calculate total protein today
        int totalProtein = 0;
        for (MacroEntry macro : log.getMacros()) {
            totalProtein += macro.getProtein();
        }

        // Score based on protein goal
        double score = ((double) totalProtein / user.getProteinGoal()) * 100;

        // Cap at 100%
        return Math.min(score, 100.0);
    }

    private double calcSleepScore() {
        // Calculate total sleep hours today
        double totalSleepHours = 0;
        for (SleepEntry sleep : log.getSleepEntries()) {
            totalSleepHours += sleep.getHours();
        }

        // Score based on sleep goal
        double score = (totalSleepHours / user.getSleepGoal()) * 100;

        // Cap at 100%
        return Math.min(score, 100.0);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FitnessLog getLog() {
        return log;
    }

    public void setLog(FitnessLog log) {
        this.log = log;
    }
}
