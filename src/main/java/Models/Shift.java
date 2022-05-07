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
            retString = "Lørdag 25/6 ";
        } else if(t < 1440*2){
            retString = "Søndag 26/6 ";
            t -= 1440;
        } else if(t < 1440*3){
            retString = "Mandag 27/6 ";
            t -= 1440*2;
        } else if(t < 1440*4){
            retString = "Tirsdag 28/6 ";
            t -= 1440*3;
        } else if(t < 1440*5){
            retString = "Onsdag 29/6 ";
            t -= 1440*4;
        } else if(t < 1440*6){
            retString = "Torsdag 30/6 ";
            t -= 1440*5;
        } else if(t < 1440*7){
            retString = "Fredag 1/7 ";
            t -= 1440*6;
        } else if(t < 1440*8){
            retString = "Lørdag 2/7 ";
            t -= 1440*7;
        } else {
            retString = "??? ";
            while (t > 1440){
                t -= 1440;
            }
        }
        int hours = t/60;
        int mins = t-(hours*60);
        return retString + " " + (hours < 10 ? "0" + hours : hours) + ":" + (mins < 10 ? "0" + mins : mins);
    }

    public int getDurationInt() {
        return duration;
    }

    public int getStartInt() {
        return start;
    }

    public String getDuration() {
        int hours = duration/60;
        int mins = duration-(hours*60);
        return (hours < 10 ? "0" + hours : hours) + ":" + (mins < 10 ? "0" + mins : mins);
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