class Timetable{
    private String day;
    private String time;
    private String coach;
    private int rating;
    private int maxCapacity;

    public Timetable(String day, String time, String coach, int rating, int maxCapacity) {
        this.day = day;
        this.time = time;
        this.coach = coach;
        this.rating = rating;
        this.maxCapacity = maxCapacity;
    }

    // Getters
    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getCoach() {
        return coach;
    }

    public int getRating() {
        return rating;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    // Setters
    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
