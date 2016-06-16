package com.focuslabs.wts.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
public class OrganizationVo implements Serializable {

    private String id;
    private String name;
    private String homePage;
    private LocationVo location;
    private UserVo admin;
    private List<EventVo> events = new ArrayList<>();
    private List<UserVo> members = new ArrayList<>();
    private List<UserVo> followers = new ArrayList<>();

    public OrganizationVo() {
    }

    public OrganizationVo(String id, String name, String homePage, LocationVo location, UserVo admin) {
        this.id = id;
        this.name = name;
        this.homePage = homePage;
        this.location = location;
        this.admin = admin;
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

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public LocationVo getLocation() {
        return location;
    }

    public void setLocation(LocationVo location) {
        this.location = location;
    }

    public UserVo getAdmin() {
        return admin;
    }

    public void setAdmin(UserVo admin) {
        this.admin = admin;
    }

    public List<EventVo> getEvents() {
        return events;
    }

    public void setEvents(List<EventVo> events) {
        this.events = events;
    }

    public List<UserVo> getMembers() {
        return members;
    }

    public void setMembers(List<UserVo> members) {
        this.members = members;
    }

    public List<UserVo> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserVo> followers) {
        this.followers = followers;
    }
}
