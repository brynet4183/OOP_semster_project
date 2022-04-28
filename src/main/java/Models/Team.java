package Models;

import java.util.List;

public class Team {
    private int id;
    private String name;
    public List<TeamAdmin> teamAdmins;
    public List<Volunteer> volunteers;

    public Team(int id, String name){
        this.id = id;
        this.name = name;
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