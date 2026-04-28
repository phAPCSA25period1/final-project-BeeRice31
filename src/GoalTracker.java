/**
 * Calculates daily fitness scores based on user goals and logged activities.
 * Compares workout, macro, and sleep data against the user's goals and returns
 * a percentage.
 */
public class GoalTracker {
    // The user whose goals are being tracked
    private User user;
    // The fitness log containing today's activity data
    private FitnessLog log;

    /**
     * Constructs a GoalTracker for a given user and fitness log.
     * 
     * @param user the User whose goals will be used for scoring
     * @param log  the FitnessLog containing today's entries
     */
    public GoalTracker(User user, FitnessLog log) {
        this.user = user;
        this.log = log;
    }

    /**
     * Calculates the overall daily fitness score as a percentage.
     * Each category (workout, macros, sleep) is weighted equally at 33%.
     * 
     * @return an integer from 0 to 100 representing the daily score
     */
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

    /**
     * Calculates the workout score based on number of workouts logged vs the goal.
     * 
     * @return a score from 0.0 to 100.0
     */
    private double calcWorkoutScore() {
        // Calculate total workouts today
        int totalWorkouts = log.getWorkouts().size();

        // Score based on workout goal
        double score = ((double) totalWorkouts / user.getWorkoutGoal()) * 100;

        // Cap at 100%
        return Math.min(score, 100.0);
    }

    /**
     * Calculates the macro score based on total protein logged vs the protein goal.
     * 
     * @return a score from 0.0 to 100.0
     */
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

    /**
     * Calculates the sleep score based on total hours slept vs the sleep goal.
     * 
     * @return a score from 0.0 to 100.0
     */
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

    /**
     * Returns the user associated with this GoalTracker.
     * 
     * @return the User object
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user for this GoalTracker.
     * 
     * @param user the new User object
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Returns the fitness log associated with this GoalTracker.
     * 
     * @return the FitnessLog object
     */
    public FitnessLog getLog() {
        return log;
    }

    /**
     * Sets the fitness log for this GoalTracker.
     * 
     * @param log the new FitnessLog object
     */
    public void setLog(FitnessLog log) {
        this.log = log;
    }
}
