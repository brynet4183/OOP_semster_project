package Models;

import java.util.List;

public class Volunteer {
    private int id;
    private int line;
    private String name;
    private String password;
    private String salt;
    private Boolean confrimed;

    public List<Shift> shifts;
    public List<Team> teams;

    public Volunteer(int id, String name, String password, String salt, Boolean confrimed){
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.confrimed = confrimed;
    }

    public int getId() {
        return id;
    }

    public Boolean getConfrimed() {
        return confrimed;
    }

    public String getName() {
        return name;
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
        if(this.password == hash(password)){
            return true;
        } else {
            return false;
        }
    }

    private String hash(String password) {
        if(this.salt == null)
            this.salt = "something";
        return password + this.salt;
    }
}