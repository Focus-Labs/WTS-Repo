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
public class Local implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String companyName;
    private Date startedDate;

    @OneToOne
    private City city;
    private String address;
    private Integer rating;
    private String phoneNo;
    private String logoPicLocation;

    @OneToOne
    private Account account;

    @ManyToMany
    @JoinTable(name = "Collaboration")
    private List<Event> eventsCollabo = new ArrayList<Event>();

    public Local() {
    }

    public Local(String companyName, Date startedDate, City city, String address, Integer rating, String phoneNo,
                 String logoPicLocation, Account account, List<Event> eventsCollabo) {
        this.companyName = companyName;
        this.startedDate = startedDate;
        this.city = city;
        this.address = address;
        this.rating = rating;
        this.phoneNo = phoneNo;
        this.logoPicLocation = logoPicLocation;
        this.account = account;
        this.eventsCollabo = eventsCollabo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

    public void setRating(Integer rating) {
        this.rating = rating;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Event> getEventsCollabo() {
        return eventsCollabo;
    }

    public void setEventsCollabo(List<Event> eventsCollabo) {
        this.eventsCollabo = eventsCollabo;
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
