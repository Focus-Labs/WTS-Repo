package com.focuslabs.wts.entity;

import java.io.Serializable;
import javax.persistence.*;
/**
 * Created by aman on 3/23/16.
 */
@Entity
public class Relationship implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Long follower_id;
    @ManyToOne
    private Long followed_id;
    private String relation_type;

    public Relationship() {
    }

    public Relationship(Long follower_id, Long followed_id, String relation_type) {
        this.follower_id = follower_id;
        this.followed_id = followed_id;
        this.relation_type = relation_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(Long follower_id) {
        this.follower_id = follower_id;
    }

    public Long getFollowed_id() {
        return followed_id;
    }

    public void setFollowed_id(Long followed_id) {
        this.followed_id = followed_id;
    }

    public String getRelation_type() {
        return relation_type;
    }

    public void setRelation_type(String relation_type) {
        this.relation_type = relation_type;
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
        if (!(object instanceof Relationship)) {
            return false;
        }
        Relationship other = (Relationship) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.Relationship[ id=" + id + " ]";
    }
}