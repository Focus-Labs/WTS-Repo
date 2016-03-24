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
public class Traveler implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private Date dateOfBirth;
    private String country;
    private String city;
    private Integer rating;
    private String email;
    private String profilePicLocation;

    @ManyToMany
    @JoinTable(name = "Participant")
    private List<Event> eventsPartic = new ArrayList<Event>();

    @OneToMany
    private List<Relationship> relationships = new ArrayList<Relationship>();

    public Traveler() {
    }

    public Traveler(String fullName, Date dateOfBirth, String country, String city, Integer rating,
                    String email, String profilePicLocation) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.city = city;
        this.rating = rating;
        this.email = email;
        this.profilePicLocation = profilePicLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getRating() {
        return rating;
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

    public String getProfilePicLocation() {
        return profilePicLocation;
    }

    public void setProfilePicLocation(String profilePicLocation) {
        this.profilePicLocation = profilePicLocation;
    }

    public List<Event> getEvents() {
        return eventsPartic;
    }

    public void setEvents(List<Event> events) {
        this.eventsPartic = events;
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
        if (!(object instanceof Traveler)) {
            return false;
        }
        Traveler other = (Traveler) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.Traveler[ id=" + id + " ]";
    }
}