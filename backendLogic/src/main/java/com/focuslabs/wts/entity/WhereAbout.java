package com.focuslabs.wts.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/**
 * Created by aman on 3/23/16.
 */
@Entity
public class WhereAbout implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Traveler traveler;
    @OneToOne
    private City city;
    private Date fromDate;
    private Date toDate;

    public WhereAbout() {
    }

    public WhereAbout(Traveler traveler, City city, Date fromDate, Date toDate) {
        this.traveler = traveler;
        this.city = city;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Traveler getTraveler() {
        return traveler;
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
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
        if (!(object instanceof WhereAbout)) {
            return false;
        }
        WhereAbout other = (WhereAbout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.WhereAbout[ id=" + id + " ]";
    }
}