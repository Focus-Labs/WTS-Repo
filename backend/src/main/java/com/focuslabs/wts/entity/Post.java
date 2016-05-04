package com.focuslabs.wts.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 * Created by aman on 3/23/16.
 */
@Entity
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String postText;

    @OneToMany
    private List<PostMedia> postMedias = new ArrayList<PostMedia>();

    public Post() {
    }

    public Post(String postText, List<PostMedia> postMedias) {
        this.postText = postText;
        this.postMedias = postMedias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public List<PostMedia> getPostMedias() {
        return postMedias;
    }

    public void setPostMedias(List<PostMedia> postMedias) {
        this.postMedias = postMedias;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.Post[ id=" + id + " ]";
    }
}