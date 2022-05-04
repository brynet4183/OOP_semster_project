package Models;

import java.util.ArrayList;
import java.util.List;

public class Volunteer implements Model{
    private int id;
    private String name;
    private String password;
    private String salt;
    private Boolean confrimed;

    public List<Shift> shifts;
    public List<Team> teams;
    public PersonalInfo personalInfo;

    public Volunteer(int id, String name, String password, String salt, Boolean confrimed){
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.confrimed = confrimed;
        teams = new ArrayList<>();
        shifts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Boolean getConfirmed() {
        return confrimed;
    }

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getSalt() {
        return salt;
    }

    public void confrim() {
        this.confrimed = true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = hash(password);
    }

    public boolean login(String password) {
        if(this.password.equals(hash(password))){
            return true;
        } else {
            return false;
        }
    }

    public void setId(int id) {
        this.id = id;
    }
    private String hash(String password) {
        if(this.salt == null)
            this.salt = "something";
        return password + this.salt;
    }
}
