package com.focuslabs.wts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 * Created by aman on 3/23/16.
 */
@Document
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long Id;
    private String postText;

    @DBRef
    private List<PostMedia> postMedias = new ArrayList<PostMedia>();

    public Post() {
    }

    public Post(String postText, List<PostMedia> postMedias) {
        this.postText = postText;
        this.postMedias = postMedias;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
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
        hash += (Id != null ? Id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the Id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.Id == null && other.Id != null) || (this.Id != null && !this.Id.equals(other.Id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.focuslabs.com.focuslabs.wts.entity.Post[ Id=" + Id + " ]";
    }
}