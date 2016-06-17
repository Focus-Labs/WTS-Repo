package com.focuslabs.wts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
/**
 * Created by aman on 3/23/16.
 */
@Document
public class Event implements Serializable{

    @Id
    private String id;
    private String title;
    private Date date;
    private String length;
    private String short_desc;
    private String long_desc;
    private String where_about;
    private String event_icon_Location;
    private String event_pic_Location;

    @DBRef
    private List<Post> posts = new ArrayList<Post>();

    @DBRef
    private List<EventMaterial> eventMaterials = new ArrayList<EventMaterial>();

    public Event() {
    }

    public Event(String title, Date date, String length, String short_desc, String long_desc, String where_about, String event_icon_Location, String event_pic_Location) {
        this.title = title;
        this.date = date;
        this.length = length;
        this.short_desc = short_desc;
        this.long_desc = long_desc;
        this.where_about = where_about;
        this.event_icon_Location = event_icon_Location;
        this.event_pic_Location = event_pic_Location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getLong_desc() {
        return long_desc;
    }

    public void setLong_desc(String long_desc) {
        this.long_desc = long_desc;
    }

    public String getWhere_about() {
        return where_about;
    }

    public void setWhere_about(String where_about) {
        this.where_about = where_about;
    }

    public String getEvent_icon_Location() {
        return event_icon_Location;
    }

    public void setEvent_icon_Location(String event_icon_Location) {
        this.event_icon_Location = event_icon_Location;
    }

    public String getEvent_pic_Location() {
        return event_pic_Location;
    }

    public void setEvent_pic_Location(String event_pic_Location) {
        this.event_pic_Location = event_pic_Location;
    }


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<EventMaterial> getEventMaterials() {
        return eventMaterials;
    }

    public void setEventMaterials(List<EventMaterial> eventMaterials) {
        this.eventMaterials = eventMaterials;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.Event[ id=" + id + " ]";
    }
}