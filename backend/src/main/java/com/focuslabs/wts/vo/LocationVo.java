package com.focuslabs.wts.vo;

/**
 * Created by baba on 6/13/2016.
 */
public class LocationVo {

    private int numberOfLocations;

    public LocationVo() {
    }

    public LocationVo(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    public int getNumberOfLocation() {
        return numberOfLocations;
    }

    public void setNumberOfLocation(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }
}
