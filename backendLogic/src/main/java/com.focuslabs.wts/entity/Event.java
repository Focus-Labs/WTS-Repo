package main.java.com.focuslabs.wts.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Event implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Date date;
    private String length;
    private String short_desc;
    private String long_desc;
    private String  where;
    private String event_icon_Location;
    private ArrayList<String> event_pic_Location;

    public Event() {
    }

    public Event(Long id, String title, Date date, String length, String short_desc, String long_desc, String where,
                 String event_icon_Location, ArrayList<String> event_pic_Location) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.length = length;
        this.short_desc = short_desc;
        this.long_desc = long_desc;
        this.where = where;
        this.event_icon_Location = event_icon_Location;
        this.event_pic_Location = event_pic_Location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getEvent_icon_Location() {
        return event_icon_Location;
    }

    public void setEvent_icon_Location(String event_icon_Location) {
        this.event_icon_Location = event_icon_Location;
    }

    public ArrayList<String> getEvent_pic_Location() {
        return event_pic_Location;
    }

    public void setEvent_pic_Location(ArrayList<String> event_pic_Location) {
        this.event_pic_Location = event_pic_Location;
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
        return "com.focuslabs.wts.entity.Event[ id=" + id + " ]";
    }
}