package com.focuslabs.wts.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by baba on 3/30/2016.
 */
public class TravelerAccountVo {

    private Long id;
    private Date dateOfBirth;
    private CountryVO.CityVO city;
    private Integer rating;
    private String profilePicLocation;
    private AccountVO account;
    private List<EventVO> events = new ArrayList<EventVO>();

    // create constructor if the constructors do not fit with ur specification


    public TravelerAccountVo(Date dateOfBirth, CountryVO.CityVO city, String profilePicLocation, AccountVO account) {
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.profilePicLocation = profilePicLocation;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CountryVO.CityVO getCity() {
        return city;
    }

    public void setCity(CountryVO.CityVO city) {
        this.city = city;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getProfilePicLocation() {
        return profilePicLocation;
    }

    public void setProfilePicLocation(String profilePicLocation) {
        this.profilePicLocation = profilePicLocation;
    }

    public AccountVO getAccount() {
        return account;
    }

    public void setAccount(AccountVO account) {
        this.account = account;
    }

    public List<EventVO> getEvents() {
        return events;
    }

}
