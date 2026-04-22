public class SleepEntry {
    private double hours;
    private String quality;
    private String date;

    public SleepEntry() {
    }

    public SleepEntry(double hours, String quality, String date) {
        this.hours = hours;
        this.quality = quality;
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}