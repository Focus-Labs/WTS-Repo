package com.focuslabs.wts.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Long fromAccountId;
    private String fromAccountType;
    @OneToOne
    private Long toAccountId;
    private String toAccountType;
    private String message;
    private Date date;
    private boolean flag_read;

    public Message() {
    }

    public Message(Long id, Long fromAccountId, String fromAccountType, Long toAccountId, String toAccountType,
                   String message, Date date, boolean flag_read) {
        this.id = id;
        this.fromAccountId = fromAccountId;
        this.fromAccountType = fromAccountType;
        this.toAccountId = toAccountId;
        this.toAccountType = toAccountType;
        this.message = message;
        this.date = date;
        this.flag_read = flag_read;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public String getFromAccountType() {
        return fromAccountType;
    }

    public void setFromAccountType(String fromAccountType) {
        this.fromAccountType = fromAccountType;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public String getToAccountType() {
        return toAccountType;
    }

    public void setToAccountType(String toAccountType) {
        this.toAccountType = toAccountType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.Message[ id=" + id + " ]";
    }
}