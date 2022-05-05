package Models;

import java.util.ArrayList;
import java.util.List;

public class Volunteer implements Model{
    private int id;
    private String name;
    private String password;
    private String salt;
    private Boolean confirmed;

    public List<Shift> shifts;
    public List<Team> teams;
    public PersonalInfo personalInfo;

    public Volunteer(int id, String name, String password, String salt, Boolean confirmed){
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.confirmed = confirmed;
        teams = new ArrayList<>();
        shifts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Boolean getConfirmed() {
        return confirmed;
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

    public void confirm() {
        this.confirmed = true;
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
