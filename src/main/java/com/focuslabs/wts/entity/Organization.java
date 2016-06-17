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
public class Organization extends Entity{

    @Id
    private String id;

    private String name;
    private String homepage;

    @DBRef
    private Location address;

    @DBRef
    private User admin;

    @DBRef
    private List<Event> events = new ArrayList<Event>();
    @DBRef
    private List<User> members = new ArrayList<User>();
    @DBRef
    private List<User> followers = new ArrayList<User>();
    @DBRef
    private List<Skill> wantedSkills = new ArrayList<Skill>();
    @DBRef
    private List<Rating> ratings = new ArrayList<Rating>();

    public Organization(){}

    public Organization(String name, String homepage,User admin,Location location) {
        this.name = name;
        this.homepage = homepage;
        this.admin = admin;
        this.address = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<Skill> getWantedSkills() {
        return wantedSkills;
    }

    public void setWantedSkills(List<Skill> wantedSkills) {
        this.wantedSkills = wantedSkills;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
