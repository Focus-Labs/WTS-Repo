package com.focuslabs.wts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import javax.persistence.*;
/**
 * Created by aman on 3/23/16.
 */
@Document
public class EventMaterial implements Serializable {

    @Id
    private String Id;
    private String materialLocation;
    private String description;
    private String materialType;

    public EventMaterial() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Id != null ? Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the Id fields are not set
        if (!(object instanceof EventMaterial)) {
            return false;
        }
        EventMaterial other = (EventMaterial) object;
        if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.EventMaterial[ Id=" + Id + " ]";
    }
}
