package Models;

public class Shift implements Model {
    private int id;
    private int start;
    private int duration;
    public Team team;
    public Volunteer volunteer;

    public Shift(int id, int start, int duration){
        this.id = id;
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public int getStart() {
        return start;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStart(int start) {
        this.start = start;
    }

}