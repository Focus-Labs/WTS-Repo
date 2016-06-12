package com.focuslabs.wts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Sam on 6/12/2016.
 */
@Document
public class Availability {

    @Id
    private String id;

    private Date fromDate;
    private Date toDate;
    @DBRef
    private Location location;

    public Availability(){}
}
