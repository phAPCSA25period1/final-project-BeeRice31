public class WorkoutEntry {
    private String type;
    private int durationMinutes;
    private int sets;
    private int reps;

    public WorkoutEntry() {
    }

    public WorkoutEntry(String type, int durationMinutes, int sets, int reps) {
        this.type = type;
        this.durationMinutes = durationMinutes;
        this.sets = sets;
        this.reps = reps;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
