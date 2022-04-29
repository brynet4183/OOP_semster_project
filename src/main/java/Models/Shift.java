package Models;

public class Shift {
    private int id;
    private int line;
    private int start;
    private int duration;
    private int team_id;
    private int volunteer_id;
    public Team team;
    public Volunteer volunteer;

    public Shift(int id, int start, int duration, int team_id, int volunteer_id){
        this.id = id;
        this.start = start;
        this.team_id = team_id;
        this.volunteer_id = volunteer_id;
    }

    public int getVolunteer_id() {
        return volunteer_id;
    }

    public int getTeam_id() {
        return team_id;
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

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setVolunteer_id(int volunteer_id) {
        this.volunteer_id = volunteer_id;
    }
}