package com.focuslabs.wts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 6/12/2016.
 */
@Document
public class User extends Entity{

    @Id
    private String id;

    private String email;
    private String password;

    private String firstName;
    private String lastName;

    private String aboutMe;
    private String education;

    @DBRef
    private List<Skill> skills = new ArrayList<Skill>();
    @DBRef
    private List<Rating> ratings = new ArrayList<Rating>();
    @DBRef
    private List<Event> events = new ArrayList<Event>();
    @DBRef
    private List<Organization> organizations = new ArrayList<Organization>();
    @DBRef
    private List<Story> stories = new ArrayList<Story>();
    @DBRef
    private List<Availability> trips = new ArrayList<Availability>();

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<Availability> getTrips() {
        return trips;
    }

    public void setTrips(List<Availability> trips) {
        this.trips = trips;
    }
}
