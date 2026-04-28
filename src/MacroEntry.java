/**
 * Represents a meal entry with macronutrient information.
 * Stores protein, carbs, and fat and can calculate total calories.
 */
public class MacroEntry {
    private String mealName;
    private int protein;
    private int carbs;
    private int fat;

    /**
     * Constructs a MacroEntry with the given meal name and macronutrient values.
     * 
     * @param mealName the name of the meal
     * @param protein  grams of protein
     * @param carbs    grams of carbohydrates
     * @param fat      grams of fat
     */
    public MacroEntry(String mealName, int protein, int carbs, int fat) {
        this.mealName = mealName;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    /**
     * Returns the name of the meal.
     * 
     * @return the meal name
     */
    public String getMealName() {
        return mealName;
    }

    /**
     * Sets the name of the meal.
     * 
     * @param mealName the meal name to set
     */
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    /**
     * Returns the grams of protein in the meal.
     * 
     * @return protein in grams
     */
    public int getProtein() {
        return protein;
    }

    /**
     * Sets the grams of protein in the meal.
     * 
     * @param protein grams of protein to set
     */
    public void setProtein(int protein) {
        this.protein = protein;
    }

    /**
     * Returns the grams of carbohydrates in the meal.
     * 
     * @return carbs in grams
     */
    public int getCarbs() {
        return carbs;
    }

    /**
     * Sets the grams of carbohydrates in the meal.
     * 
     * @param carbs grams of carbs to set
     */
    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    /**
     * Returns the grams of fat in the meal.
     * 
     * @return fat in grams
     */
    public int getFat() {
        return fat;
    }

    /**
     * Sets the grams of fat in the meal.
     * 
     * @param fat grams of fat to set
     */
    public void setFat(int fat) {
        this.fat = fat;
    }

    /**
     * Calculates and returns the total calories in the meal.
     * Uses standard values: protein = 4 cal/g, carbs = 4 cal/g, fat = 9 cal/g.
     * 
     * @return total calories as an integer
     */
    public int calculateCalories() {
        return (protein * 4) + (carbs * 4) + (fat * 9);
    }
}
