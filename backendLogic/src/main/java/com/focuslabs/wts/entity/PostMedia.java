package com.focuslabs.wts.entity;

import java.io.Serializable;
import javax.persistence.*;
/**
 * Created by aman on 3/23/16.
 */
@Entity
public class PostMedia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String resourceLocation;
    private String resourceType;

    public PostMedia() {
    }

    public PostMedia(String resourceLocation, String resourceType) {
        this.resourceLocation = resourceLocation;
        this.resourceType = resourceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostMedia)) {
            return false;
        }
        PostMedia other = (PostMedia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.PostMedia[ id=" + id + " ]";
    }
}