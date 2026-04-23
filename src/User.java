public class User {
    private String name;
    private String fitnessGoals;
    private int calorieGoal;
    private int proteinGoal;
    private int sleepGoal;
    private int workoutGoal;

    public User() {
        this.calorieGoal = 2000;
        this.proteinGoal = 150;
        this.sleepGoal = 8;
        this.workoutGoal = 1;
    }

    public User(String name, String fitnessGoals) {
        this.name = name;
        this.fitnessGoals = fitnessGoals;
        this.calorieGoal = 2000;
        this.proteinGoal = 150;
        this.sleepGoal = 8;
        this.workoutGoal = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public int getProteinGoal() {
        return proteinGoal;
    }

    public void setProteinGoal(int proteinGoal) {
        this.proteinGoal = proteinGoal;
    }

    public int getSleepGoal() {
        return sleepGoal;
    }

    public void setSleepGoal(int sleepGoal) {
        this.sleepGoal = sleepGoal;
    }

    public int getWorkoutGoal() {
        return workoutGoal;
    }

    public void setWorkoutGoal(int workoutGoal) {
        this.workoutGoal = workoutGoal;
    }
}
