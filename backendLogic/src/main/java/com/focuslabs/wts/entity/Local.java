package com.focuslabs.wts.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
/**
 * Created by aman on 3/23/16.
 */
@Entity
public class Local extends Account implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String spokesPersonName;
    private String companyName;
    private Date startedDate;
    private Long cityId;
    private String address;
    private Integer rating;
    private String email;
    private String phoneNo;
    private String logoPicLocation;

    @ManyToMany
    @JoinTable(name = "Collaboration")
    private List<Event> eventsCollabo = new ArrayList<Event>();

    @OneToMany
    private List<Relationship> relationships = new ArrayList<Relationship>();

    public Local() {
    }

    public Local(String spokesPersonName, String companyName, Date startedDate, Long cityId, String address,
                 Integer rating, String email, String phoneNo, String logoPicLocation, List<Event> eventsCollabo,
                 List<Relationship> relationships) {
        this.spokesPersonName = spokesPersonName;
        this.companyName = companyName;
        this.startedDate = startedDate;
        this.cityId = cityId;
        this.address = address;
        this.rating = rating;
        this.email = email;
        this.phoneNo = phoneNo;
        this.logoPicLocation = logoPicLocation;
        this.eventsCollabo = eventsCollabo;
        this.relationships = relationships;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpokesPersonName() {
        return spokesPersonName;
    }

    public void setSpokesPersonName(String spokesPersonName) {
        this.spokesPersonName = spokesPersonName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRating() {
        return rating;
    }

    public List<Event> getEventsCollabo() {
        return eventsCollabo;
    }

    public void setEventsCollabo(List<Event> eventsCollabo) {
        this.eventsCollabo = eventsCollabo;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLogoPicLocation() {
        return logoPicLocation;
    }

    public void setLogoPicLocation(String logoPicLocation) {
        this.logoPicLocation = logoPicLocation;
    }

    public List<Event> getEvents() {
        return eventsCollabo;
    }

    public void setEvents(List<Event> events) {
        this.eventsCollabo = events;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.local[ id=" + id + " ]";
    }
}
