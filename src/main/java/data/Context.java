package data;
import Models.*;

import java.util.*;


public class Context {
    public DataMap<Integer, Shift> Shifts = new DataMap<Integer, Shift>();
    public DataMap<Integer, PersonalInfo> PersonalInfos = new DataMap<Integer, PersonalInfo>();
    public DataMap<Integer,Team> Teams = new DataMap<Integer,Team>();
    public DataMap<Integer,TeamAdmin> TeamAdmins = new DataMap<Integer,TeamAdmin>();
    public DataMap<Integer,Volunteer> Volunteers = new DataMap<Integer,Volunteer>();

    private void load(){
        Shifts = new DataMap<Integer, Shift>();
        PersonalInfos = new DataMap<Integer, PersonalInfo>();
        Teams = new DataMap<Integer,Team>();
        TeamAdmins = new DataMap<Integer,TeamAdmin>();
        Volunteers = new DataMap<Integer,Volunteer>();
        List<String> in = new ArrayList<String>();
        in = Reader.Read("teams");
        //id,name
        for (String inLine : in) {
            String[] line = inLine.split(";");
            Teams.put(Integer.parseInt(line[0]), new Team(Integer.parseInt(line[0]), line[1]));
        }
        in = new ArrayList<String>();
        in = Reader.Read("personalInfo");
        //id,firstName,lastName,language,email,phone,country,zip,city,street,number
        for (String inLine : in) {
            String[] line = inLine.split(";");
            PersonalInfos.put(Integer.parseInt(line[0]), new PersonalInfo(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4], line[5], line[6], Integer.parseInt(line[7]), line[8], line[9], line[10]));
        }
        in = new ArrayList<String>();
        in = Reader.Read("teamAdmins");
        //id,name,password,salt,team_id,personalInfo_id
        for (String inLine : in) {
            String[] line = inLine.split(";");
            TeamAdmins.put(Integer.parseInt(line[0]), new TeamAdmin(Integer.parseInt(line[0]), line[1], line[2], line[3]));
            TeamAdmins.get(Integer.parseInt(line[0])).team = Teams.get(Integer.parseInt(line[4]));
            Teams.get(Integer.parseInt(line[4])).teamAdmins.add(TeamAdmins.get(Integer.parseInt(line[0])));
            TeamAdmins.get(Integer.parseInt(line[0])).personalInfo = PersonalInfos.get(Integer.parseInt(line[5]));
            PersonalInfos.get(Integer.parseInt(line[5])).teamAdmins.add(TeamAdmins.get(Integer.parseInt(line[0])));
        }
        in = new ArrayList<String>();
        in = Reader.Read("volunteers");
        //id,name,password,salt,confirmed,personalInfo_id
        for (String inLine : in) {
            String[] line = inLine.split(";");
            Volunteers.put(Integer.parseInt(line[0]), new Volunteer(Integer.parseInt(line[0]), line[1], line[2], line[3], Boolean.parseBoolean(line[4])));
            Volunteers.get(Integer.parseInt(line[0])).personalInfo = PersonalInfos.get(Integer.parseInt(line[5]));
            PersonalInfos.get(Integer.parseInt(line[5])).volunteers.add(Volunteers.get(Integer.parseInt(line[0])));
        }
        in = new ArrayList<String>();
        in = Reader.Read("shifts");
        //id,start,duration,team_id,volunteer_id
        for (String inLine : in) {
            String[] line = inLine.split(";");
            Shifts.put(Integer.parseInt(line[0]), new Shift(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])));
            Shifts.get(Integer.parseInt(line[0])).team = Teams.get(Integer.parseInt(line[3]));
            Shifts.get(Integer.parseInt(line[0])).volunteer = Volunteers.get(Integer.parseInt(line[4]));
            Teams.get(Integer.parseInt(line[3])).shifts.add(Shifts.get(Integer.parseInt(line[0])));
            Volunteers.get(Integer.parseInt(line[4])).shifts.add(Shifts.get(Integer.parseInt(line[0])));
        }
        in = new ArrayList<String>();
        in = Reader.Read("volunteer_teams");
        //team_id,volunteer_id
        for (String inLine : in) {
            String[] line = inLine.split(";");
            Teams.get(Integer.parseInt(line[0])).volunteers.add(Volunteers.get(Integer.parseInt(line[1])));
            Volunteers.get(Integer.parseInt(line[1])).teams.add(Teams.get(Integer.parseInt(line[0])));
        }
    }
    public Context(){
        load();
    }
    public void Save(){
        List<String> outTeams = new ArrayList<String>();
        List<String> outPersonalInfos = new ArrayList<String>();
        List<String> outTeamAdmins = new ArrayList<String>();
        List<String> outVolunteers = new ArrayList<String>();
        List<String> outShifts = new ArrayList<String>();
        List<String> outVolunteerTeams = new ArrayList<String>();
        for (Team team : Teams.values()) {
            int id = team.getId();
            //id,name
            outTeams.add(id + ";" + team.getName());
            //team_id,volunteer_id
            if(team.volunteers != null){
                for (Volunteer v: team.volunteers) {
                    outVolunteerTeams.add(id + ";" + v.getId());
                }
            }
        }
        //id,firstName,lastName,language,email,phone,country,zip,city,street,number
        for (PersonalInfo pi : PersonalInfos.values()) {
            outPersonalInfos.add(pi.getId() + ";" + pi.getFirstName() + ";" + pi.getLastName() + ";" + pi.getLanguage() + ";" + pi.getEmail() + ";" + pi.getPhone() + ";" + pi.getCountry() + ";" + pi.getZip() + ";" + pi.getCity() + ";" + pi.getStreet() + ";" + pi.getNumber());
        }
        //id,name,password,salt,team_id,personalInfo_id
        for (TeamAdmin ta : TeamAdmins.values()) {
            outTeamAdmins.add(ta.getId() + ";" + ta.getName() + ";" + ta.getPassword() + ";" + ta.getSalt() + ";" + ta.team.getId() + ";" + ta.personalInfo.getId());
        }
        //id,name,password,salt,confirmed,personalInfo_id
        for (Volunteer v : Volunteers.values()) {
            System.out.println(v.getId() + ";" + v.getName() + ";" + v.getPassword() + ";" + v.getSalt() + ";" + v.getConfirmed() + ";" + v.personalInfo.getId());
            outVolunteers.add(v.getId() + ";" + v.getName() + ";" + v.getPassword() + ";" + v.getSalt() + ";" + v.getConfirmed() + ";" + v.personalInfo.getId());
        }
        //id,start,duration,team_id,volunteer_id
        for (Shift s : Shifts.values()) {
            outShifts.add(s.getId() + ";" + s.getStartInt() + ";" + s.getDurationInt() + ";" + s.team.getId() + ";" + s.volunteer.getId());
        }
        Writer.Write("personalInfo", outPersonalInfos);
        Writer.Write("teams", outTeams);
        Writer.Write("volunteer_teams", outVolunteerTeams);
        Writer.Write("teamAdmins", outTeamAdmins);
        Writer.Write("volunteers", outVolunteers);
        Writer.Write("shifts", outShifts);
        load();
    }
}
