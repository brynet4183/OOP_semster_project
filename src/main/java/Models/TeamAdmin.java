package Models;

import javax.print.DocFlavor;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;
import java.util.Random;

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
    private String generateSalt(){
        byte[] array = new byte[20];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    public void securePassword(){
        if(Objects.equals(this.salt, "something")){
            this.salt = generateSalt();
            this.password = hash(this.password.substring(0,this.password.length()-9));
        }
    }
    private String hash(String password) {
        if(this.salt == null)
            this.salt = generateSalt();
        password = password + salt;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Arrays.toString(Base64.getEncoder().encode(hash));
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }

    public boolean login(String password) {
        if(this.password.equals(hash(password)))
            return true;
        else
            return false;
    }

}
