/**
 * Represents a sleep record for a single night.
 * Stores hours slept, quality rating, and the date of the record.
 */
public class SleepEntry {
    // Number of hours slept
    private double hours;
    // Quality rating (e.g., "Good", "Fair", "Poor")
    private String quality;
    // Date of the sleep record (YYYY-MM-DD)
    private String date;

    /**
     * Constructs a SleepEntry with the given hours, quality, and date.
     * 
     * @param hours   number of hours slept
     * @param quality quality rating of the sleep
     * @param date    date of the sleep record in YYYY-MM-DD format
     */
    public SleepEntry(double hours, String quality, String date) {
        this.hours = hours;
        this.quality = quality;
        this.date = date;
    }

    /**
     * Returns the number of hours slept.
     * 
     * @return hours slept as a double
     */
    public double getHours() {
        return hours;
    }

    /**
     * Sets the number of hours slept.
     * 
     * @param hours number of hours to set
     */
    public void setHours(double hours) {
        this.hours = hours;
    }

    /**
     * Returns the quality rating of the sleep.
     * 
     * @return sleep quality as a String
     */
    public String getQuality() {
        return quality;
    }

    /**
     * Sets the quality rating of the sleep.
     * 
     * @param quality the quality rating to set
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    /**
     * Returns the date of the sleep record.
     * 
     * @return date as a String in YYYY-MM-DD format
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the sleep record.
     * 
     * @param date the date to set in YYYY-MM-DD format
     */
    public void setDate(String date) {
        this.date = date;
    }
}
