package com.focuslabs.wts.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by baba on 3/30/2016.
 */
public class LocalAccountVo {

    private Long id;
    private String companyName;
    private Date startedDate;
    private CountryVO.CityVO city;
    private String address;
    private Integer rating;
    private String phoneNo;
    private String logoPicLocation;
    private AccountVO account;
    private List<EventVO> events = new ArrayList<EventVO>();

    // create constructor if the constructors do not fit with ur specification


    public LocalAccountVo(String companyName, Date startedDate, CountryVO.CityVO city, String address, String phoneNo, String logoPicLocation, AccountVO account) {
        this.companyName = companyName;
        this.startedDate = startedDate;
        this.city = city;
        this.address = address;
        this.phoneNo = phoneNo;
        this.logoPicLocation = logoPicLocation;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public CountryVO.CityVO getCity() {
        return city;
    }

    public void setCity(CountryVO.CityVO city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLogoPicLocation() {
        return logoPicLocation;
    }

    public void setLogoPicLocation(String logoPicLocation) {
        this.logoPicLocation = logoPicLocation;
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
