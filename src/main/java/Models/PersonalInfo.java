package Models;

import java.util.ArrayList;
import java.util.List;

public class PersonalInfo {
    int id;
    String lastName;
    String language;
    String email;
    String phone;
    String country;
    int zip;
    String city;
    String street;
    String number;
    public List<TeamAdmin> teamAdmins;
    public List<Volunteer> volunteers;

    public PersonalInfo(int id, String lastName, String language, String email, String phone, String country, int zip, String  city, String  street, String  number){
        this.id = id;
        this.lastName = lastName;
        this.language = language;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.zip = zip;
        this.city = city;
        this.street = street;
        this.number = number;
        teamAdmins = new ArrayList<>();
        volunteers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getLanguage() {
        return language;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
