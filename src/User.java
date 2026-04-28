/**
 * Represents a user profile with fitness goals and daily targets.
 * Stores the user's name, fitness goal description, and numeric goals for
 * protein, sleep, and workouts.
 */
public class User {
    // User's name
    private String name;
    // User's fitness goal description
    private String fitnessGoals;
    // Daily protein goal in grams
    private int proteinGoal;
    // Daily sleep goal in hours
    private int sleepGoal;
    // Weekly workout goal (number of sessions)
    private int workoutGoal;

    /**
     * Constructs a User with a name and fitness goal description, using default
     * numeric goals.
     * 
     * @param name         the user's name
     * @param fitnessGoals a description of the user's fitness goals
     */
    public User(String name, String fitnessGoals) {
        this.name = name;
        this.fitnessGoals = fitnessGoals;
        this.proteinGoal = 150;
        this.sleepGoal = 8;
        this.workoutGoal = 1;
    }

    /**
     * Returns the user's name.
     * 
     * @return the name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the user's fitness goal description.
     * 
     * @return fitness goals as a String
     */
    public String getFitnessGoals() {
        return fitnessGoals;
    }

    /**
     * Sets the user's fitness goal description.
     * 
     * @param fitnessGoals the fitness goals to set
     */
    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    /**
     * Returns the daily protein goal in grams.
     * 
     * @return protein goal as an integer
     */
    public int getProteinGoal() {
        return proteinGoal;
    }

    /**
     * Sets the daily protein goal in grams.
     * 
     * @param proteinGoal the protein goal to set
     */
    public void setProteinGoal(int proteinGoal) {
        this.proteinGoal = proteinGoal;
    }

    /**
     * Returns the daily sleep goal in hours.
     * 
     * @return sleep goal as an integer
     */
    public int getSleepGoal() {
        return sleepGoal;
    }

    /**
     * Sets the daily sleep goal in hours.
     * 
     * @param sleepGoal the sleep goal to set
     */
    public void setSleepGoal(int sleepGoal) {
        this.sleepGoal = sleepGoal;
    }

    /**
     * Returns the weekly workout goal in number of sessions.
     * 
     * @return workout goal as an integer
     */
    public int getWorkoutGoal() {
        return workoutGoal;
    }

    /**
     * Sets the weekly workout goal in number of sessions.
     * 
     * @param workoutGoal the workout goal to set
     */
    public void setWorkoutGoal(int workoutGoal) {
        this.workoutGoal = workoutGoal;
    }
}
