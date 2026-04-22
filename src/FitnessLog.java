import java.util.ArrayList;

public class FitnessLog {
    private ArrayList<WorkoutEntry> workouts;
    private ArrayList<MacroEntry> macros;
    private ArrayList<SleepEntry> sleepEntries;

    public FitnessLog() {
        workouts = new ArrayList<>();
        macros = new ArrayList<>();
        sleepEntries = new ArrayList<>();
    }

    public ArrayList<WorkoutEntry> getWorkouts() {
        return workouts;
    }

    public void addWorkout(WorkoutEntry workout) {
        workouts.add(workout);
    }

    public ArrayList<MacroEntry> getMacros() {
        return macros;
    }

    public void addMacro(MacroEntry macro) {
        macros.add(macro);
    }

    public ArrayList<SleepEntry> getSleepEntries() {
        return sleepEntries;
    }

    public void addSleepEntry(SleepEntry sleep) {
        sleepEntries.add(sleep);
    }
}