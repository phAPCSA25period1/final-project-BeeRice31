/**
 * Represents a single workout session with exercise details.
 * Stores the exercise type, duration, sets, and reps.
 */
public class WorkoutEntry {
    // Type of exercise (e.g., "Cardio", "Strength")
    private String type;
    // Duration of workout in minutes
    private int durationMinutes;
    // Number of sets performed
    private int sets;
    // Number of reps per set
    private int reps;

    /**
     * Constructs a WorkoutEntry with the given exercise details.
     * 
     * @param type            the type of exercise
     * @param durationMinutes the duration of the workout in minutes
     * @param sets            the number of sets performed
     * @param reps            the number of reps per set
     */
    public WorkoutEntry(String type, int durationMinutes, int sets, int reps) {
        this.type = type;
        this.durationMinutes = durationMinutes;
        this.sets = sets;
        this.reps = reps;
    }

    /**
     * Returns the type of exercise.
     * 
     * @return exercise type as a String
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of exercise.
     * 
     * @param type the exercise type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the duration of the workout in minutes.
     * 
     * @return duration in minutes as an integer
     */
    public int getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * Sets the duration of the workout in minutes.
     * 
     * @param durationMinutes the duration to set
     */
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    /**
     * Returns the number of sets performed.
     * 
     * @return number of sets as an integer
     */
    public int getSets() {
        return sets;
    }

    /**
     * Sets the number of sets performed.
     * 
     * @param sets the number of sets to set
     */
    public void setSets(int sets) {
        this.sets = sets;
    }

    /**
     * Returns the number of reps per set.
     * 
     * @return number of reps as an integer
     */
    public int getReps() {
        return reps;
    }

    /**
     * Sets the number of reps per set.
     * 
     * @param reps the number of reps to set
     */
    public void setReps(int reps) {
        this.reps = reps;
    }
}
