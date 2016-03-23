package main.java.com.focuslabs.wts.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class EventMaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Long eventId;
    private String materialLocation;
    private String description;
    private String materialType;

    @OneToOne
    private Long travelerId;

    public EventMaterial() {
    }

    public EventMaterial(Long id, Long eventId, String materialLocation, String description, String materialType,
                         Long travelerId) {
        this.id = id;
        this.eventId = eventId;
        this.materialLocation = materialLocation;
        this.description = description;
        this.materialType = materialType;
        this.travelerId = travelerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getMaterialLocation() {
        return materialLocation;
    }

    public void setMaterialLocation(String materialLocation) {
        this.materialLocation = materialLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Long getTravelerId() {
        return travelerId;
    }

    public void setTravelerId(Long travelerId) {
        this.travelerId = travelerId;
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
        if (!(object instanceof EventMaterial)) {
            return false;
        }
        EventMaterial other = (EventMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.wts.entity.EventMaterial[ id=" + id + " ]";
    }
}
