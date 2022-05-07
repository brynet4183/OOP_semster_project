package Models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

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

    private String generateSalt(){
        byte[] array = new byte[20];
        new Random().nextBytes(array);
        return Arrays.toString(Base64.getEncoder().encode(array));
    }

    public void securePassword(){
        if(Objects.equals(this.salt, "something")){
            this.salt = generateSalt();
            this.password = hash(this.password.substring(0,this.password.length()-9));
        }
        this.salt = Arrays.toString(Base64.getEncoder().encode(this.salt.getBytes(StandardCharsets.UTF_8)));
    }

    private static String getStringFromSalt(String string) {
        String[] bytes = string.replace("[", "").replace("]", "").split(", ");
        byte[] array = new byte[bytes.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Byte.parseByte(bytes[i]);
        }
        return new String(Base64.getDecoder().decode(array), StandardCharsets.UTF_8);
    }

    private String hash(String password) {
        if(this.salt == null)
            this.salt = generateSalt();
        password = password + getStringFromSalt(salt);
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Arrays.toString(Base64.getEncoder().encode(hash));
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
