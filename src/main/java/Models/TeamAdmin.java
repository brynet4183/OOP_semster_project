package Models;

import javax.print.DocFlavor;

public class TeamAdmin implements Model{
    private int id;
    private String name;
    private String password;
    private String salt;
    public Team team;
    public PersonalInfo personalInfo;

    public TeamAdmin(int id, String name, String password, String salt){
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = hash(password);
    }

    public void setName(String name) {
        this.name = name;
    }

    private String hash(String password) {
        if(this.salt == null)
            this.salt = "something";
        return password + this.salt;
    }

    public boolean login(String password) {
        if(this.password.equals(hash(password)))
            return true;
        else
            return false;
    }

}
