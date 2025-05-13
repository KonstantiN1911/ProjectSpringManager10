package com.example.ProjectSpringManager10;

public class Athlete {
    private String lastName;
    private String firstName;
    private String gender;
    private String distance;
    private String time;

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTime() {
        return time;
    }

    public String getGender() {
        return gender;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Athlete(String firstName, String lastName, String gender, String distance, String time) {
        this.distance = distance;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.time = time;
    }
}
