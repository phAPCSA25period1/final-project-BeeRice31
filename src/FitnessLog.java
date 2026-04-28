
/**
 * Stores collections of daily fitness data including workouts, meals, and sleep records.
 * Represents a journal of all of the data that is tracked
 */
import java.util.ArrayList;

public class FitnessLog {
    // List of workout entries
    private ArrayList<WorkoutEntry> workouts;
    // List of meal entries
    private ArrayList<MacroEntry> macros;
    // List of sleep entries
    private ArrayList<SleepEntry> sleepEntries;

    /**
     * Constructs a FitnessLog with empty lists for all entry types.
     */
    public FitnessLog() {
        workouts = new ArrayList<>();
        macros = new ArrayList<>();
        sleepEntries = new ArrayList<>();
    }

    /**
     * Returns the list of workout entries.
     * 
     * @return list of WorkoutEntry objects
     */
    public ArrayList<WorkoutEntry> getWorkouts() {

        return workouts;
    }

    /**
     * Adds a workout entry to the log.
     * 
     * @param workout the WorkoutEntry to add
     */
    public void addWorkout(WorkoutEntry workout) {
        workouts.add(workout);
    }

    /**
     * Returns the list of macro entries.
     * 
     * @return list of MacroEntry objects
     */
    public ArrayList<MacroEntry> getMacros() {

        return macros;
    }

    /**
     * Adds a macro entry to the log.
     * 
     * @param macro the MacroEntry to add
     */
    public void addMacro(MacroEntry macro) {
        macros.add(macro);
    }

    /**
     * Returns the list of sleep entries.
     * 
     * @return list of SleepEntry objects
     */
    public ArrayList<SleepEntry> getSleepEntries() {
        return sleepEntries;
    }

    /**
     * Adds a sleep entry to the log.
     * 
     * @param sleep the SleepEntry to add
     */
    public void addSleepEntry(SleepEntry sleep) {
        sleepEntries.add(sleep);
    }
}
