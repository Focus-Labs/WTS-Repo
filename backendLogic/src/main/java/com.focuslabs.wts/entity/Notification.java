package main.java.com.focuslabs.wts.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Long travelerId;
    @OneToOne
    private Long localId;
    private String notif_message;
    private Date date;
    private boolean flag_read;

    public Notification() {
    }

    public Notification(Long id, Long travelerId, Long localId, String notif_message, Date date, boolean flag_read) {
        this.id = id;
        this.travelerId = travelerId;
        this.localId = localId;
        this.notif_message = notif_message;
        this.date = date;
        this.flag_read = flag_read;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTravelerId() {
        return travelerId;
    }

    public void setTravelerId(Long travelerId) {
        this.travelerId = travelerId;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.wts.entity.Notification[ id=" + id + " ]";
    }
}