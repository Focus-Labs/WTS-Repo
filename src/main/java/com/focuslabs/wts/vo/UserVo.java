package com.focuslabs.wts.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
public class UserVo implements Serializable{

    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String aboutMe;
    private String education;
    private List<OrganizationVo> organizations = new ArrayList<>();
    private List<EventVo> events = new ArrayList<>();

    public UserVo() {
    }

    public UserVo(String id, String email, String password, String firstName, String lastName, String aboutMe, String education) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.aboutMe = aboutMe;
        this.education = education;
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

    public List<OrganizationVo> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<OrganizationVo> organizations) {
        this.organizations = organizations;
    }

    public List<EventVo> getEvents() {
        return events;
    }

    public void setEvents(List<EventVo> events) {
        this.events = events;
    }
}
