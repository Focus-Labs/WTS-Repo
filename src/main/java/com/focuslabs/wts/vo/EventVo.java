package com.focuslabs.wts.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by baba on 6/13/2016.
 */
public class EventVo implements Serializable {

    private String id;
    private String title;
    private Date date;
    private String length;
    private String shortDescription;
    private String longDescription;
    private String whereAbout;
    private String eventIconLocation;
    private String eventPictureLocation;

    public EventVo() {
    }

    public EventVo(String id, String title, Date date, String length, String shortDescription, String longDescription, String whereAbout, String eventIconLocation, String eventPictureLocation) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.length = length;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.whereAbout = whereAbout;
        this.eventIconLocation = eventIconLocation;
        this.eventPictureLocation = eventPictureLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getWhereAbout() {
        return whereAbout;
    }

    public void setWhereAbout(String whereAbout) {
        this.whereAbout = whereAbout;
    }

    public String getEventIconLocation() {
        return eventIconLocation;
    }

    public void setEventIconLocation(String eventIconLocation) {
        this.eventIconLocation = eventIconLocation;
    }

    public String getEventPictureLocation() {
        return eventPictureLocation;
    }

    public void setEventPictureLocation(String eventPictureLocation) {
        this.eventPictureLocation = eventPictureLocation;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
