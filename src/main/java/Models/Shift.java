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

    private String timeCalc(int t){
        String retString = "";
        if(t < 1440){
            retString = "Lørdag ";
        } else if(t < 1440*2){
            retString = "Søndag ";
            t -= 1440;
        } else if(t < 1440*3){
            retString = "Mandag ";
            t -= 1440*2;
        } else if(t < 1440*4){
            retString = "Tirsdag ";
            t -= 1440*3;
        } else if(t < 1440*5){
            retString = "Onsdag ";
            t -= 1440*4;
        } else if(t < 1440*6){
            retString = "Torsdag ";
            t -= 1440*5;
        } else if(t < 1440*7){
            retString = "Fredag ";
            t -= 1440*6;
        } else if(t < 1440*8){
            retString = "Lørdag ";
            t -= 1440*7;
        } else {
            retString = "??? ";
            while (t > 1440){
                t -= 1440;
            }
        }
        int hours = t/60;
        int mins = t-(hours*60);
        return retString + " " + hours + ":" + mins;
    }

    public String getDuration() {
        int hours = duration/60;
        int mins = duration-(hours*60);
        return hours + ":" + mins;
    }

    public String getStart() {
        return timeCalc(start);
    }

    public String getEnd() {
        return timeCalc(start+duration);
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