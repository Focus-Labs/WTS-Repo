package main.java.com.focuslabs.wts.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Participants implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Long event_id;
    @ManyToOne
    private Long traveler_id;

    public Participants() {
    }

    public Participants(Long id, Long event_id, Long traveler_id) {
        this.id = id;
        this.event_id = event_id;
        this.traveler_id = traveler_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public Long getTraveler_id() {
        return traveler_id;
    }

    public void setTraveler_id(Long traveler_id) {
        this.traveler_id = traveler_id;
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
        if (!(object instanceof Participants)) {
            return false;
        }
        Participants other = (Participants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.wts.entity.Participants[ id=" + id + " ]";
    }
}