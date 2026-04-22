public class User {
    private String name;
    private String fitnessGoals;

    public User() {
    }

    public User(String name, String fitnessGoals) {
        this.name = name;
        this.fitnessGoals = fitnessGoals;
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
}