package com.focuslabs.wts.vo;

/**
 * Created by baba on 6/13/2016.
 */
public class LocationVo {

    private String id;
    private String name;

    public LocationVo() {
    }

    public LocationVo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
