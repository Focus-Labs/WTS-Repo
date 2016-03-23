package main.java.com.focuslabs.wts.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Collaboration implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Long event_id;
    @ManyToOne
    private Long local_id;

    public Collaboration() {
    }

    public Collaboration(Long id, Long event_id, Long local_id) {
        this.id = id;
        this.event_id = event_id;
        this.local_id = local_id;
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

    public Long getLocal_id() {
        return local_id;
    }

    public void setLocal_id(Long local_id) {
        this.local_id = local_id;
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
        if (!(object instanceof Collaboration)) {
            return false;
        }
        Collaboration other = (Collaboration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.wts.entity.Collaboration[ id=" + id + " ]";
    }
}