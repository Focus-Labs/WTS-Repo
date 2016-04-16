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
    private Date dateOfBirth;

    @OneToOne
    private City city;
    private Integer rating;
    private String profilePicLocation;

    @OneToOne
    private Account account;

    @ManyToMany
    @JoinTable(name = "Participant")
    private List<Event> eventsPartic = new ArrayList<Event>();

    public Traveler() {
    }

    /**
     * constructor for creating traveler account
     *
     * @param dateOfBirth
     * @param city
     * @param profilePicLocation
     * @param account
     */
    public Traveler(Date dateOfBirth, City city, String profilePicLocation, Account account) {
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.profilePicLocation = profilePicLocation;
        this.account = account;
    }

    public Traveler(Date dateOfBirth, City city, Integer rating, String profilePicLocation, Account account,
                    List<Event> eventsPartic) {
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.rating = rating;
        this.profilePicLocation = profilePicLocation;
        this.account = account;
        this.eventsPartic = eventsPartic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getProfilePicLocation() {
        return profilePicLocation;
    }

    public void setProfilePicLocation(String profilePicLocation) {
        this.profilePicLocation = profilePicLocation;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Event> getEventsPartic() {
        return eventsPartic;
    }

    public void setEventsPartic(List<Event> eventsPartic) {
        this.eventsPartic = eventsPartic;
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