package Models;

import java.util.ArrayList;
import java.util.List;

public class Team implements Model{
    private int id;
    private String name;
    public List<TeamAdmin> teamAdmins;
    public List<Volunteer> volunteers;
    public List<Shift> shifts;

    public Team(int id, String name){
        this.id = id;
        this.name = name;
        teamAdmins = new ArrayList<>();
        volunteers = new ArrayList<>();
        shifts = new ArrayList<>();
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}