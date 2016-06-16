package com.focuslabs.wts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import javax.persistence.*;
/**
 * Created by aman on 3/23/16.
 */
@Document
public class PostMedia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long Id;
    private String resourceLocation;
    private String resourceType;

    public PostMedia() {
    }

    public PostMedia(String resourceLocation, String resourceType) {
        this.resourceLocation = resourceLocation;
        this.resourceType = resourceType;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getResourceLocation() {
        return resourceLocation;
    }

    public void setResourceLocation(String resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
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
        if (!(object instanceof PostMedia)) {
            return false;
        }
        PostMedia other = (PostMedia) object;
        if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.PostMedia[ Id=" + Id + " ]";
    }
}