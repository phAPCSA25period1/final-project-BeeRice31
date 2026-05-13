/**
 * Tracks fitness scores across a 7-day week using a 2D array.
 * Each row represents a day and each column represents a category score.
 * Generative AI was used for debugging and planning how to implement the code
 */
public class WeeklyTracker {

    /** Number of days in a week */
    private static final int DAYS = 7;

    /** Number of score categories (workout, protein, sleep) */
    private static final int CATEGORIES = 3;

    /** Column index for workout score */
    private static final int WORKOUT = 0;

    /** Column index for protein score */
    private static final int PROTEIN = 1;

    /** Column index for sleep score */
    private static final int SLEEP = 2;

    /** Day labels for display */
    private static final String[] DAY_NAMES = {
            "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
    };

    /** 2D array storing scores for each day and category */
    private int[][] weeklyScores;

    /** Index of the current day being tracked (0 = Monday) */
    private int currentDay;

    /**
     * Constructs a WeeklyTracker with all scores initialized to -1.
     * -1 indicates that no data has been logged for that day yet.
     */
    public WeeklyTracker() {
        weeklyScores = new int[DAYS][CATEGORIES];
        for (int i = 0; i < DAYS; i++) {
            for (int j = 0; j < CATEGORIES; j++) {
                weeklyScores[i][j] = -1;
            }
        }
        currentDay = 0;
    }

    /**
     * Logs today's category scores into the weekly tracker.
     *
     * @param workoutScore the workout score for today (0-100)
     * @param proteinScore the protein score for today (0-100)
     * @param sleepScore   the sleep score for today (0-100)
     */
    public void logDay(int workoutScore, int proteinScore, int sleepScore) {
        if (currentDay < DAYS) {
            weeklyScores[currentDay][WORKOUT] = workoutScore;
            weeklyScores[currentDay][PROTEIN] = proteinScore;
            weeklyScores[currentDay][SLEEP] = sleepScore;
            currentDay++;
        }
    }

    /**
     * Calculates the average score for a given category across all logged days.
     *
     * @param category the column index of the category to average
     * @return the average score as a double, or 0 if no days have been logged
     */
    private double getCategoryAverage(int category) {
        int total = 0;
        int count = 0;
        for (int i = 0; i < currentDay; i++) {
            if (weeklyScores[i][category] != -1) {
                total += weeklyScores[i][category];
                count++;
            }
        }
        return count > 0 ? (double) total / count : 0;
    }

    /**
     * Prints a formatted weekly summary table to the console.
     * Shows each day's scores for all three categories and weekly averages.
     */
    public void printWeeklySummary() {
        System.out.println("\n+======================================+");
        System.out.printf("|  %-36s|%n", "WEEKLY SUMMARY");
        System.out.println("+======================================+");
        System.out.println("  Day   | Workout | Protein |  Sleep  |  Daily ");
        System.out.println("  ----------------------------------------");

        for (int i = 0; i < DAYS; i++) {
            if (weeklyScores[i][WORKOUT] == -1) {
                System.out.printf("  %-5s |   --    |   --    |   --    |   -- %n",
                        DAY_NAMES[i]);
            } else {
                int daily = (weeklyScores[i][WORKOUT] +
                        weeklyScores[i][PROTEIN] +
                        weeklyScores[i][SLEEP]) / 3;
                System.out.printf("  %-5s |  %3d%%   |  %3d%%   |  %3d%%   |  %3d%%%n",
                        DAY_NAMES[i],
                        weeklyScores[i][WORKOUT],
                        weeklyScores[i][PROTEIN],
                        weeklyScores[i][SLEEP],
                        daily);
            }
        }

        System.out.println("  ----------------------------------------");
        System.out.printf("  Avg   |  %3.0f%%   |  %3.0f%%   |  %3.0f%%   |%n",
                getCategoryAverage(WORKOUT),
                getCategoryAverage(PROTEIN),
                getCategoryAverage(SLEEP));
        System.out.println("+======================================+");
    }

    /**
     * Returns the full 2D array of weekly scores.
     *
     * @return the weeklyScores 2D array
     */
    public int[][] getWeeklyScores() {
        return weeklyScores;
    }

    /**
     * Returns the index of the current day being tracked.
     *
     * @return the current day index
     */
    public int getCurrentDay() {
        return currentDay;
    }
}
