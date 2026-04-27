public class MacroEntry {
    private String mealName;
    private int protein;
    private int carbs;
    private int fat;

    public MacroEntry() {
    }

    public MacroEntry(String mealName, int protein, int carbs, int fat) {
        this.mealName = mealName;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    // Calculate total calories: protein=4 cal/g, carbs=4 cal/g, fat=9 cal/g
    public int calculateCalories() {
        return (protein * 4) + (carbs * 4) + (fat * 9);
    }
}
