package com.focuslabs.wts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
/**
 * Created by aman on 3/23/16.
 */
@Document
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long Id;
    private String notif_message;
    private Date date;
    private boolean flag_read;

    public Notification() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getNotif_message() {
        return notif_message;
    }

    public void setNotif_message(String notif_message) {
        this.notif_message = notif_message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isFlag_read() {
        return flag_read;
    }

    public void setFlag_read(boolean flag_read) {
        this.flag_read = flag_read;
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
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.Notification[ Id=" + Id + " ]";
    }
}